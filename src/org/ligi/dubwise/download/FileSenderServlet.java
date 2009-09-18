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

public class FileSenderServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger( EnterCodeServlet.class.getName());


 public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws  IOException {
     
	 String uri= request.getRequestURI();
	 String mail_txt="request_url: "+uri+"\nUA: "  + request.getHeader("user-agent") + "\n";
	 Boolean send_installer=false;
	 DUBwiseProps props=new DUBwiseProps();	
	 int id=-1;

	 if (uri.endsWith("DUBwiseInstaller.jar")|| (uri.endsWith("DUBwiseInstaller.jad")))
	     send_installer=true;
	 else 
	     {
		 id= Integer.parseInt(uri.split("/") [uri.split("/").length-1].split("\\.")[0]);

		 PersistenceManager pm = PMF.get().getPersistenceManager();
		 
		 try {
		     InstallRecord rec= pm.getObjectById(InstallRecord.class, id);
		     props.set_code(rec.getCode());
		     if(uri.endsWith(".jar"))
			 rec.setJARRequested(true);
		     else
			 rec.setJADRequested(true);
		     
		     if (rec.getInstallerVersion()==null)
			 {
			     mail_txt+="sending new installer - installer version was not send!\n";
			     send_installer=true;
			 }
		     
		     PersistentDevice device=pm.getObjectById(PersistentDevice.class,rec.getDeviceId());
		     device.setBrowserUserAgent( request.getHeader("user-agent"));
		     pm.makePersistent(device);
		     pm.makePersistent(rec);
		     mail_txt+="device: " + device.info_text()+"\n";
		     
		 } finally {
		     pm.close();
		 }
		 
	     }

	 if (uri.endsWith(".jar"))
	     {
		 if (send_installer)
		     {
			 DownloadHelper.admin_email(" Installer Sender (JAR)", "sending : " +  SourceInfoProvider.installer_source_base_URL() +".jar\n" + mail_txt );		 	
			 response.sendRedirect(SourceInfoProvider.installer_source_base_URL() +".jar" );
		     }	 
		 else
		     {
			 DownloadHelper.admin_email(" File Sender (JAR)",  SourceInfoProvider.getDownloadURL() + "trunk/"+ props.getJADFileName() + "\n" + mail_txt);		 	
			 response.sendRedirect(SourceInfoProvider.getDownloadURL() + "trunk/"+ props.getJARFileName() );
			 //response.setContentType("application/java-archive");
		     }
	     }
	 else
	     {
		 if (send_installer)
		     {
			 DownloadHelper.admin_email(" Installer Sender (JAD)", "sending : " +  SourceInfoProvider.installer_source_base_URL() +".jad\n"  + mail_txt );		 	
			 response.sendRedirect(SourceInfoProvider.installer_source_base_URL() +".jad" );
		     }
		 else
		     {
			 DownloadHelper.admin_email(" File Sender (JAD)",  SourceInfoProvider.getDownloadURL() + "trunk/"+ props.getJADFileName() + "\n" + mail_txt);		 	
			 response.setContentType("text/vnd.sun.j2me.app-descriptor");
			 //		 response.getWriter().print(InstallHelper.read_http_str(SourceInfoProvider.getDownloadURL() + "trunk/"+ props.getJADFileName() ).replaceFirst("MIDlet-Jar-URL: ","MIDlet-Jar-URL: "+SourceInfoProvider.getDownloadURL()+"trunk/") );
			 
			 response.getWriter().print(InstallHelper.read_http_str(SourceInfoProvider.getDownloadURL() + "trunk/"+ props.getJADFileName() ).replaceFirst("MIDlet-Jar-URL:(.*)\n","MIDlet-Jar-URL: http://dubwise-download.appspot.com"+uri.replaceFirst(".jad",".jar")+"\n" ));
			 response.getWriter().print("MIDlet-Install-Notify: " + SourceInfoProvider.install_notify_URL() + id+"\n");
			 response.getWriter().print("MIDlet-Delete-Notify: " + SourceInfoProvider.delete_notify_URL() + id + "\n") ;
		     }
	     }
	     // a .last function for array like in ruby would make this less ugly ,,,
            
  }

}
