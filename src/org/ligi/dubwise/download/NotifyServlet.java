package org.ligi.dubwise.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Properties;

import javax.jdo.PersistenceManager;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotifyServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException, ServletException {
		resp.getWriter().println("should use post");
}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {

		BufferedReader reader = req.getReader();
		
		String install_res="";
		
		int c;
		while ((c=reader.read())!=-1)
				{
				install_res+=(char)c;
				}
		
	        boolean install_notify=false;
	        boolean delete_notify=false;
	        
	        String id_str=req.getParameter("delete");

	        
	        if (id_str!=null)
	        	delete_notify=true;
	        else 
	        {
	        	id_str=req.getParameter("install");
	        	
	        	if (id_str!=null)
	 	        	install_notify=true;
	        }
	        	

	   	 PersistenceManager pm = PMF.get().getPersistenceManager();
	   	long device_id; 
	   	 try {
	   		 	InstallRecord rec= pm.getObjectById(InstallRecord.class, Integer.parseInt(id_str));
	   		 	if (install_notify)rec.setInstallResult(install_res);
	   		 	if (delete_notify)rec.setDeleteResult(install_res);
	   		 	device_id=rec.getDeviceId();
	   		 	pm.makePersistent(rec);
	   	 } finally {
	   	    	 pm.close();
	   	 }
	        
	   	 // mail the result
	   	String subj="DUBwise ";
        if (install_notify) subj+="Install Notify";
        else if (delete_notify) subj+="Delete Notify";
        else  subj+="Notify Err";
        
        DownloadHelper.admin_email(subj, "Install ID: " +id_str + "\nResult: "+install_res + "\nDevice ID: " + device_id);
        
	}
}
