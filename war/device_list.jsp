<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.*" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="org.ligi.dubwise.download.PersistentUniqueDevice" %>
<%@ page import="org.ligi.dubwise.download.PersistentDevice" %>
<%@ page import="org.ligi.dubwise.download.CodeRecorder" %>
<%@ page import="org.ligi.dubwise.download.BuildRecord" %>
<%@ page import="org.ligi.dubwise.download.PMF" %>
<%@ page import="org.ligi.dubwise.download.SourceInfoProvider" %>
<%@ page import="org.ligi.dubwise.download.InstallRecord" %>



<%@ include file='layout_p.jsp' %>

<%
PersistenceManager pm = PMF.get().getPersistenceManager();
 String query;
 Query q;
%>

<div class="post">
 <h1 class="title">Devices:</h1>
 <div class="entry">
<ul>
<%                            
  query = "select from " + PersistentUniqueDevice.class.getName() ;
  List<PersistentUniqueDevice> devices = (List<PersistentUniqueDevice>) pm.newQuery(query).execute();
  for (PersistentUniqueDevice d : devices) {
%>
<li><a href="device_info.jsp?id=<%= d.getExampleDeviceId() %>"><%= d.getPlatform() %></a></li>

<% } %>
</ul>
</div></div>

<%@ include file='layout_s.jsp' %>


