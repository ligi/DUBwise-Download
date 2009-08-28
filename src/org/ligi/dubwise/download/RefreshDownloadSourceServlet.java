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
import org.ligi.dubwise.download.DownloadSourceInfoRecord;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.*;
import java.nio.*;


import java.util.*;
import javax.jdo.Query;

// ...

public class RefreshDownloadSourceServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger( EnterCodeServlet.class.getName());

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
	SourceInfoProvider.update_act_version();
	resp.setContentType("text/plain");
	resp.getWriter().print("OK");
    }
}