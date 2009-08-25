<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.*" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>




<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>

<%@ page import="org.ligi.dubwise.download.PersistentDevice" %>
<%@ page import="org.ligi.dubwise.download.CodeRecorder" %>
<%@ page import="org.ligi.dubwise.download.BuildRecord" %>
<%@ page import="org.ligi.dubwise.download.PMF" %>

<html>


  <head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css" />
  </head>

  <body>

<h1>DUBwise Stats</h1>



<%
DatastoreService datastore =DatastoreServiceFactory.getDatastoreService();
		 
    PersistenceManager pm = PMF.get().getPersistenceManager();
//    String query = "select from " + BuildRecord.class.getName() + " where update_flag==true ";



      Query query = new Query("BuildRecord");
      


 	int res= datastore.prepare(query).countEntities() ;
//Query q = pm.newQuery( BuildRecord.class);
//int count = 0; 

 //   List< BuildRecord> brs = (List< BuildRecord>) pm.newQuery(query).execute();

//  for ( BuildRecord r : brs) {
//	count++; }

%>

---<%= ""+ res %><br/>



  </body>
</html>
