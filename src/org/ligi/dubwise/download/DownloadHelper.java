package org.ligi.dubwise.download;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class DownloadHelper {

		public static void admin_email(String subject,String text)
		{

			// send mail
			Properties props = new Properties();
		        Session session = Session.getDefaultInstance(props, null);

		        try {
		            Message msg = new MimeMessage(session);
		            msg.setFrom(new InternetAddress("marcus.bueschleb@googlemail.com"));
		            msg.addRecipient(Message.RecipientType.TO,
		                             new InternetAddress("marcus.bueschleb@googlemail.com"));
		            msg.setSubject("[DUBwise-Download] " + subject);
		            msg.setText(text);
		            Transport.send(msg);


		        } catch (Exception e) {
		        	// dont care if failing
		        } 

		}
}
