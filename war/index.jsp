<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ page import="org.ligi.dubwise.download.PMF" %>


<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Free Radicals
Description: A two-column, fixed-width design with dark color scheme background.
Version    : 1.0
Released   : 20081230

-->

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>DUBwise Downloader</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css" media="screen" />
</head>
<body>

<div id="wrapper">

<div id="header">
	<div id="logo">
		<h1><a href="#">DUBwise Download</a></h1>
		<p>Design by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a></p>
	</div>
	<!-- end #logo -->
	<!--
	<div id="menu">
		<ul>
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Products</a></li>
			<li><a href="#">Services</a></li>
			<li><a href="#">Contact Us</a></li>
		</ul>
	</div>
	-->
	<!-- end #menu -->
</div>
<!-- end #header -->
<div id="page">
	<div id="content">
<!--		<div style="margin-bottom: 10px;"><img src="images/img11.gif" alt="" /></div> -->
		<div class="post">

			<h1 class="title">Introduction:</h1>
			<div class="entry">

				<p>This site is designed to give <a href="http://www.mikrokopter.de/ucwiki/en/DUBwise">DUBwise</a> users the chance to download the app for their phone on any internet client they want instead of using online install on their phone which is often much more expensive.	</p>
			</div>
		</div>
		<div class="post">
			<h2 class="title">Step 1</h2>
			<div class="entry">
				<p>

<img style="float:left;margin-right:20px" src="images/installer_screenshot.png"/>

<ul>

<li>Download the  <a href="http://www.mikrokopter.de/ucwiki/en/DUBwiseInstaller">DUBwise J2ME Installer</a> from <a href="http://mikrocontroller.cco-ev.de/mikrosvn/Projects/DUBwise/trunk/j2me/installer/bin/">here</a> 
</li>
<li>
run it on your mobile phone
</li>
<li>
select "show Install Code" as Install Method
</li>
<li>
press OK and remember the Install-Code shown
</li>
</ul>

</p>
<div style="clear:both;"></div>	
				</div>
			<div class="meta">
				<p class="links"></p>
			</div>

		</div>
	

		<div class="post">
			<h2 class="title">Step 2</h2>
			<div class="entry">
				<p>

 <form action="/download_by_code" method="post">
      
	Enter the Code and download.

	<div>Install-Code:<input name="install_code" size="5" ></input><input type="submit" value="Download JAR" name="down_jar_btn" /> <input type="submit" value="Download JAD" name="down_jad_btn" />

      <div>

<% if (request.getParameter("wrongcode")!=null) { %>
<br/>
<div style="background-color:red;border-style:solid;">Invalid Code<br/></div>
<% } %>
</div>


</div>


    </form>

				</p>
			</div>

		</div>

	</div>
	<!-- end #content -->
	<div id="sidebar">
		<div id="sidebar-bgtop"></div>
		<div id="sidebar-content">
			<div id="sidebar-bgbtm">
			<ul>
				<!-- <li id="search">
					<h2>Search</h2>
					<form method="get" action="">
						<fieldset>
						<input type="text" id="s" name="s" value="" />
						<input type="submit" id="x" value="Search" />
						</fieldset>
					</form>
				</li> -->
				<li>
					<h2>Links</h2>
					<ul>

						<li><a href="http://www.mikrokopter.de/ucwiki/en/DUBwise">DUBwise</a></li>	
						<li><a href="http://www.mikrokopter.de">MikroKopter</a></li>	

						<li><a href="http://ligi.de">Ligi's Blog</a></li>

					</ul>
				</li>
			</ul>
		</div>
	<img src="http://code.google.com/appengine/images/appengine-noborder-120x30.gif"
alt="Powered by Google App Engine" />
		</div>
	</div>
	<!-- end #sidebar -->
	<div style="clear:both; margin:0;"></div>
</div>
<!-- end #page -->

</div>

<div id="footer">
	<p>&copy; 2009. Some Rights Reserved. Design by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.</p>
</div>

<!-- end #footer -->

<!-- Start of StatCounter Code -->
<script type="text/javascript">
var sc_project=4944502; 
var sc_invisible=1; 
var sc_partition=57; 
var sc_click_stat=1; 
var sc_security="4311d1f6"; 
</script>

<script type="text/javascript"
src="http://www.statcounter.com/counter/counter.js"></script><noscript><div
class="statcounter"><a title="counter customizable"
href="http://www.statcounter.com/free_hit_counter.html"
target="_blank"><img class="statcounter"
src="http://c.statcounter.com/4944502/0/4311d1f6/1/"
alt="counter customizable" ></a></div></noscript>
<!-- End of StatCounter Code -->

</body>
</html>



   


