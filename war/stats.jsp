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


		<div class="post">
			<h2 class="title">Developer</h2>
			<div class="entry">
				<p>
					When users install via the online install-method the installer collects information about the device and the install process.
					These  informations ( like screensize , API's , .. ) are collected to help improving dubwise on special device conditions. 
					But there is another use of it - developers of j2me applications can use these informations to get deeper insight about devices. 
					There are very big devices information sites on the internet - but they are often missing  important information. 
					</p>
					<ul>
						<li><a href="
						?what=device_records">Devices</a> ( a list of all devices which used the installer )</li> 
						<li><a href="?what=install_records">Install Log</a></li> 
					</ul>
					

<div style="clear:both;"></div>	
				</div>
		</div>

<%
PersistenceManager pm = PMF.get().getPersistenceManager();
 String query;
 Query q;
 
 boolean show_device_records=false;
 boolean show_build_records=false;	
 boolean show_code_records=false;	
 boolean show_install_records=false;	
 
 try {
     show_device_records=request.getParameter("what").equals("device_records");
     show_build_records=request.getParameter("what").equals("build_records");
     show_code_records=request.getParameter("what").equals("code_records");
     show_install_records=request.getParameter("what").equals("install_records");

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
<% } %>



<% if (show_install_records) { %>

<div class="post">
 <h1 class="title">Installations:</h1>
 <div class="entry">

<%                            
     query = "select from " + InstallRecord.class.getName() ; //+ " order by date desc range 0,5";
    List<InstallRecord> i_records = (List<InstallRecord>) pm.newQuery(query).execute();

  for (InstallRecord i : i_records) {
PersistentDevice i_device=pm.getObjectById(PersistentDevice.class, i.getDeviceId());

%>
<b>via</b> <%=i.getInstallerSource() %>
<b>with Result</b> <%=i.getInstallResult() %>
<b>on</b><a href="device_info.jsp?id=<%=i_device.getId() %>"><%=i_device.getPlatform() %></a> 

<br/>


<% } %>
</div></div>
<% } %>

<%@ include file='layout_s.jsp' %>


