<%@ include file="layout_p.jsp" %>
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
<%@ include file="layout_s.jsp" %>   

