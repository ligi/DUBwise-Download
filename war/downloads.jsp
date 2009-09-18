<%String act_site = "get_installer";%>
<%@ include file="layout_p.jsp" %>
<div class="post">
	<h1 class="title">DUBwise Installer</h1>
	<div class="entry">
	   <ul>
	     <li><a href="<%= SourceInfoProvider.installer_extern_base_URL() %>.jar">DUBwiseInstaller.jar</a></li>
	     
	     <li> <a href="<%= SourceInfoProvider.installer_extern_base_URL() %>.jad">DUBwiseInstaller.jad</a></li>
	     </ul>
	</div>
</div>

<div class="post">
<h2 class="title">Get DUBwise via Install Code</h2>
<div class="entry">
<p>
<form action="/download_by_code" method="post">Enter the Code and
download.

<div>Install-Code:<input name="install_code"
	value="<%=((request.getParameter("wrongcode") != null) ? request
							.getParameter("wrongcode") : "")%>"
	size="5"></input><input type="submit" value="Download JAR"
	name="down_jar_btn" /> <input type="submit" value="Download JAD"
	name="down_jad_btn" />

<div>
<%
	if (request.getParameter("wrongcode") != null) {
%> <br />
<div style="background-color: red; border-style: solid;"><img
	src="http://images2.wikia.nocookie.net/uncyclopedia/images/thumb/8/82/Exclam.png/50px-Exclam.png"
	style="float: left; margin-left: 5px; margin-top: 5px; margin-right: 15px" />
<h3>Invalid Code</h3>
<b style="color: black">Please make sure you read the instructions
on how to get the install-code below.</b> <br />

</div>
<%
	}
%>
</div>


</div>


</form>

</p>
</div>

</div>



<a name="windows_mobile"></a>
<div class="post">
	<h1 class="title">DUBwise for Windows Mobile</h1>
	<div class="entry">
	
		<ul>
		<li><a href="<%= SourceInfoProvider.getStableDownloadURL() %>240x320.zip">240x320.zip</a></li>
		<li><a href="<%= SourceInfoProvider.getStableDownloadURL() %>340x400.zip">340x400.zip</a></li>
	  	<li><a href="<%= SourceInfoProvider.getStableDownloadURL() %>480x640.zip">480x640.zip</a></li>
	    </ul>
	</div>
</div>


<%@ include file="layout_s.jsp" %>