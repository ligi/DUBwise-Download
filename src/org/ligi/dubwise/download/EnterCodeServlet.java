package org.ligi.dubwise.download;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import org.ligi.dubwise.download.PMF;

public class EnterCodeServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger( EnterCodeServlet.class.getName());

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {

	DUBwiseProps dubwise_props=new DUBwiseProps();
	if (dubwise_props.set_code(req.getParameter("install_code")))
	    {
		String url_to_redirect=SourceInfoProvider.getStableDownloadURL();
		
		if (req.getParameter("down_jar_btn")!=null)
				url_to_redirect+=dubwise_props.getJARFileName();
		else
				url_to_redirect+=dubwise_props.getJADFileName();
		
		DownloadHelper.admin_email("Offline Download", "code: "+req.getParameter("install_code") +"\nfile" + url_to_redirect + "\nUA: " + req.getHeader("user-agent"));
		
		//	 	store in Database
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(new CodeRecorder( req.getParameter("install_code"), new Date(),req.getHeader("user-agent"),url_to_redirect));
        } finally {
            pm.close();
        }
        
		resp.sendRedirect(url_to_redirect);
	    	
	    }
	else
	    resp.sendRedirect("downloads.jsp?wrongcode="+req.getParameter("install_code")) ;
    }


}
