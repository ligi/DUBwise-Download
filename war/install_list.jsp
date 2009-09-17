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
 <h1 class="title">Installations:</h1>
 <div class="entry">

<table border="1">
<tr>
<th>Device</th>
<th>Result</th>
<th>Source</th>
</tr>

<%                            
     query = "select from " + InstallRecord.class.getName() ; //+ " order by date desc range 0,5";
    List<InstallRecord> i_records = (List<InstallRecord>) pm.newQuery(query).execute();

  for (InstallRecord i : i_records) {
PersistentDevice i_device=pm.getObjectById(PersistentDevice.class, i.getDeviceId());

%>
<tr>
<td><a href="device_info.jsp?id=<%=i_device.getId() %>"><%=i_device.getPlatform() %></a> </td>

<% if (i.getInstallResult()==null) { %>
 <td style="background-color:yellow;color:black" >none</td>
<% } else {
String bg_color="";
if (i.getInstallResult().startsWith("900"))
   bg_color="green";
else if (i.getInstallResult().startsWith("902")) // cancel
   bg_color="yellow";
else if (i.getInstallResult().startsWith("901")) // mem
   bg_color="red";
else if (i.getInstallResult().startsWith("904")) // jar size missmatch
   bg_color="red";
else if (i.getInstallResult().startsWith("907")) // invalid jar
   bg_color="red";

 %>
 <td style="color:black;background-color:<%= bg_color %>"><%= i.getInstallResult() %></td>

<% } %>

<td> <%=(i.getInstallerSource()==null)?"---":i.getInstallerSource() %></td>
</tr>
<% } %>

</table>
</div></div>

<%@ include file='layout_s.jsp' %>


