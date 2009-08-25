<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.*" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
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
    PersistenceManager pm = PMF.get().getPersistenceManager();
    String query = "select from " + BuildRecord.class.getName() + " where update_flag==true ";
// 	int res= pm.prepare(query).countEntities() ;
Query q = pm.newQuery( BuildRecord.class);
int count = 0; 

    List< BuildRecord> brs = (List< BuildRecord>) pm.newQuery(query).execute();

  for ( BuildRecord r : brs) {
	count++; }

%>

---<%= ""+ count %><br/>



<%

     query = "select from " + CodeRecorder.class.getName() + " order by date desc range 0,5";
    List<CodeRecorder> codes = (List<CodeRecorder>) pm.newQuery(query).execute();

  for (CodeRecorder r : codes) {

%>
<%= r.getCode() %>
<%= r.getDate() %>
<%= r.getUserAgent() %><br/>
<br/>


<% } %>qq


-----


<%                            
     query = "select from " + PersistentDevice.class.getName() + " order by date desc range 0,5";
    List<PersistentDevice> devices = (List<PersistentDevice>) pm.newQuery(query).execute();

  for (PersistentDevice d : devices) {

%>
<%= d.getPlatform() %>
<%= d.getDate() %><br/>
<br/>


<% } %>


  </body>
</html>
