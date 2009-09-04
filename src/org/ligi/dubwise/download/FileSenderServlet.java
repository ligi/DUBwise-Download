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
	 int id= Integer.parseInt(uri.split("/") [uri.split("/").length-1].split("\\.")[0]);
	 

	 PersistenceManager pm = PMF.get().getPersistenceManager();
	 DUBwiseProps props=new DUBwiseProps();	
	 
	 try {
		 	InstallRecord rec= pm.getObjectById(InstallRecord.class, id);
		 	props.set_code(rec.getCode());
		 	
		 	PersistentDevice device=pm.getObjectById(PersistentDevice.class,rec.getDeviceId());
		 	device.setBrowserUserAgent( request.getHeader("user-agent"));
		 	pm.makePersistent(device);
		 	
		 	DownloadHelper.admin_email(" File Sender",  uri + "\n" + device.info_text() + "\nUA: " + request.getHeader("user-agent"));		 	
	 	
	 } finally {
	    	 pm.close();
	 }
	 
	 if (uri.endsWith(".jar"))
    	 //response.setContentType("application/java-archive");
	 	response.sendRedirect( InstallHelper.read_http_str(SourceInfoProvider.getDownloadURL() + "trunk/"+ props.getJARFileName() ));
     else
     {
    	 	response.setContentType("text/vnd.sun.j2me.app-descriptor");
    	 	response.getWriter().print(InstallHelper.read_http_str(SourceInfoProvider.getDownloadURL() + "trunk/"+ props.getJADFileName() ).replaceFirst("MIDlet-Jar-URL: ","MIDlet-Jar-URL: "+SourceInfoProvider.getDownloadURL()+"trunk/") );
    	 	response.getWriter().print("MIDlet-Install-Notify: " + SourceInfoProvider.install_notify_URL() + id+"\n");
    	 	response.getWriter().print("MIDlet-Delete-Notify: " + SourceInfoProvider.delete_notify_URL() + id + "\n") ;
    	 	
     }
	 
	 
	 
	 	

     
	
	     // a .last function for array like in ruby would make this less ugly ,,,
            
  }

}
