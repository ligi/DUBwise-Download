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

        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(install_record);
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
            msg.setSubject("DUBwise Install Request");
            msg.setText("code:"+req.getParameter("install_code"));
            Transport.send(msg);
	    log.log(Level.INFO,"Email Send code" + req.getParameter("install_code") );

        } catch (Exception e) {
	    log.log(Level.WARNING,"exception while sending mail " +e );
            // dont care if failing
        } 
 
	resp.setContentType("text/plain");
	resp.getWriter().print(""+install_record.getId());

    }




}
