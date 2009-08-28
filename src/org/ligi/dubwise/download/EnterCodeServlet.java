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


	// store in Database
        Date date = new Date();
        CodeRecorder code_record = new CodeRecorder( req.getParameter("install_code"), date,req.getHeader("user-agent"));

        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(code_record);
        } finally {
            pm.close();
        }

	// send mail
	Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("marcus.bueschleb@googlemail.com"));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress("ligi@ligi.de"));
            msg.setSubject("DUBwise Downloader Download");
            msg.setText("code:"+req.getParameter("install_code"));
            Transport.send(msg);
	    log.log(Level.INFO,"Email Send code" + req.getParameter("install_code") );

        } catch (Exception e) {
	    log.log(Level.WARNING,"exception while sending mail " +e );
            // dont care if failing
        } 
 
	DUBwiseProps dubwise_props=new DUBwiseProps();
	if (dubwise_props.set_code(req.getParameter("install_code")))
	    resp.sendRedirect("http://ligi.selfip.org/ligi/dubwise_dl/tags/"+(	(req.getParameter("down_jar_btn")==null)?dubwise_props.getJADFileName():dubwise_props.getJARFileName()) );
	else
	    resp.sendRedirect("download_by_code.jsp?wrongcode=true");
    }


}
