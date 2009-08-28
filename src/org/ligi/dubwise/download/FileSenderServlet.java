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
      
     if (request.getRequestURI().endsWith(".jar"))
	 response.setContentType("application/java-archive");
     else
	 response.setContentType("text/vnd.sun.j2me.app-descriptor");


     response.getWriter().println("Hello, world" + request.getRequestURI()  );
  }

}
