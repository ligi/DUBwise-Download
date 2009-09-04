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
import org.ligi.dubwise.download.*;

public class GetInstallRecordServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger( EnterCodeServlet.class.getName());

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {


	// store in Database
        Date date = new Date();
        InstallRecord install_record = new InstallRecord(req.getParameter("code"),date,new Long(req.getParameter("device_id")));
        install_record.setInstallerSource(req.getParameter("source"));
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(install_record);
        } finally {
            pm.close();
        }

        DownloadHelper.admin_email("Install Request", "code:"+req.getParameter("code") + " \nid: "+install_record.getId() + " \nsource:" +req.getParameter("source"));

	resp.setContentType("text/plain");
	resp.getWriter().print(""+install_record.getId());

    }




}
