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

<%@ include file='layout_p.jsp' %>
<%
PersistenceManager pm = PMF.get().getPersistenceManager();
 String query;
 Query q;
 
 boolean show_device_records=false;
 boolean show_build_records=false;	
 boolean show_code_records=false;	
 
 try {
     show_device_records=request.getParameter("what").equals("device_records");
     show_build_records=request.getParameter("what").equals("build_records");
     show_code_records=request.getParameter("what").equals("code_records");

 }
 catch(Exception e) { }
%>


<% if (show_build_records) { %>


Build Records:
<%
    
    query = "select from " + BuildRecord.class.getName() + " where update_flag==true ";
    // 	int res= pm.prepare(query).countEntities() ;
    q = pm.newQuery( BuildRecord.class);
    int count = 0; 

    List< BuildRecord> brs = (List< BuildRecord>) pm.newQuery(query).execute();

  for ( BuildRecord r : brs) {
	count++; }

%>

---<%= ""+ count %><br/>

<% } %>


<% if (show_code_records) { %>
<%

     query = "select from " + CodeRecorder.class.getName() + " order by date desc range 0,5";
    List<CodeRecorder> codes = (List<CodeRecorder>) pm.newQuery(query).execute();

  for (CodeRecorder r : codes) {

%>
<%= r.getCode() %>
<%= r.getDate() %>
<%= r.getUserAgent() %><br/>
<br/>


<% } %>

<% } %>


<% if (show_device_records) { %>

<div class="post">
 <h1 class="title">Devices:</h1>
 <div class="entry">

<%                            
     query = "select from " + PersistentDevice.class.getName() + " order by date desc range 0,5";
    List<PersistentDevice> devices = (List<PersistentDevice>) pm.newQuery(query).execute();

  for (PersistentDevice d : devices) {

%>
<%= d.getPlatform() %>
<%= d.getDate() %><br/>
<br/>


<% } %>
</div></div>
<% } %>

<%@ include file='layout_s.jsp' %>


