<%@ include file="layout_p.jsp" %>
		<div class="post">
			<h2 class="title">Get DUBwise via Install Code</h2>
			<div class="entry">
				<p>

 <form action="/download_by_code" method="post">
      
	Enter the Code and download.

	<div>Install-Code:<input name="install_code"  value="<%= ( (request.getParameter("wrongcode")!=null)?request.getParameter("wrongcode"):"")  %>" size="5" ></input><input type="submit" value="Download JAR" name="down_jar_btn" /> <input type="submit" value="Download JAD" name="down_jad_btn" />

      <div>

<% if (request.getParameter("wrongcode")!=null) { %>
<br/>
<div style="background-color:red;border-style:solid;">
 <img src="http://images2.wikia.nocookie.net/uncyclopedia/images/thumb/8/82/Exclam.png/50px-Exclam.png" style="float:left;margin-left:5px;margin-top:5px;margin-right:15px"/>
 <h3>Invalid Code</h3>
 <b style="color:black">Please make sure you read the instructions on how to get the install-code below.</b>
 <br/>
 
 </div>
<% } %>
</div>


</div>


    </form>

				</p>
			</div>

		</div>	



		<div class="post">
			<h2 class="title">How to get the Install Code</h2>
			<div class="entry">
				<p>

<img style="float:left;margin-right:20px" src="images/installer_screenshot.png"/>

<ul>

<li>Download the  <a href="http://www.mikrokopter.de/ucwiki/en/DUBwiseInstaller">DUBwise J2ME Installer</a> from <a href="get_installer.jsp">here</a> 
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



<%@ include file="layout_s.jsp" %>   

