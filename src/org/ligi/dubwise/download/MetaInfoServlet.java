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

public class MetaInfoServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger( EnterCodeServlet.class.getName());


 public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws  IOException {
     String[] uri_path= request.getRequestURI().split("/");
     String  requested_info =uri_path[uri_path.length-1];
     if( requested_info.equals("dl_url"))
	 {
    	 response.getWriter().println("http://ligi.selfip.org/ligi/");
	 }
	 else
	     response.getWriter().println("?");
	     
     
  }

}
