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
					These  informations are collected to help improving DUBwise on special device conditions. 
					But there is another use of it - developers of j2me applications can use this growing information-pool to get deeper insight about devices. 
					There are very big device information sites on the net - but they are often missing  important information. 
					</p>
					<ul>
						<li><a href="device_list.jsp">Devices</a> ( a list of all devices which used the installer )</li> 
						<li><a href="install_list.jsp">Install Log</a></li> 
					</ul>
					<a href="http://github.com/ligi/DUBwise-J2ME-Installer/tree/master">Here</a> you can find the SourceCode of the Installer to see how the Information is collected.
<div style="clear:both;"></div>	
				</div>
		</div>

<%@ include file='layout_s.jsp' %>


