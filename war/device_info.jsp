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
<%@ page import="org.ligi.dubwise.download.SourceInfoProvider" %>
<%@ page import="org.ligi.dubwise.download.InstallRecord" %>



<%@ include file='layout_p.jsp' %>


<%
PersistenceManager pm = PMF.get().getPersistenceManager();
 String query;
 Query q;
 
Long id=Long.parseLong(request.getParameter("id"));
PersistentDevice device=pm.getObjectById(PersistentDevice.class, id);
 
 %>
<div class="post">
 <h1 class="title"><%= device.getPlatform() %></h1>
 <div class="entry">

<table border="1">

<tr>
<th>Property</th>
<th>Value</th>
</tr>

<% String[][] info_arr=device.info_array(); %>

<% for (int i=0;i<info_arr.length;i++) { %>
<tr>
<td><b><%= info_arr[i][0] %></b></td>
<td><%= info_arr[i][1] %></td>
</tr>
<% } // for %>


</table> 

</div></div>
<%@ include file='layout_s.jsp' %>

