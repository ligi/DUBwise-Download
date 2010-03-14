<%@ include file="layout_p.jsp" %>


<a name="get_code"></a>

		<div class="post">
			<h2 class="title">Android</h2>
			<div class="entry">
				<p>
With Android it is very easy - just go to the market and search for DUBwise or use this QR-Code:<br/>
<img src="http://chart.apis.google.com/chart?cht=qr&chs=256x256&chl=http://dubwise_download.appspot.com/help.jsp"/><br/>
With your Android Handset you can also direclty use this <a href="market://search/?q=pname:org.ligi.android.dubwise">Market Link</a>.

				</p>
			</div>
		</div>


		<div class="post">
			<h2 class="title">J2ME</h2>
			<div class="entry">
				<p>
					You have the choice of mainly 2 Install Methods. 
					You can either use the online-install method - 
					this is the easyest way but it might produce some traffic costs by your provider. 
					Or you download your version via the install code calculated by the installer. This is how you use the Download by Install Code: 
				</p>		
				<p>

<img style="float:left;margin-right:20px" src="images/installer_screenshot.png"/>

<ul>

<li>Download the  <a href="http://www.mikrokopter.de/ucwiki/en/DUBwiseInstaller">DUBwise J2ME Installer</a> from <a href="downloads.jsp">here</a> 
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
<li>
go to <a href="http://dubwise-download.appspot.com/downloads.jsp#code">this page </a> 
</li>
<li>
enter the Install-Code and Download the JAR ( on some Phones - e.g. some Nokias you will need the JAD too )
</li>
</ul>

</p>
<div style="clear:both;"></div>	
				</div>
			<div class="meta">
				<p class="links"></p>
			</div>

		</div>

<a name="windows_mobile"></a>
		<div class="post">
			<h2 class="title">Windows Mobile</h2>
			<div class="entry">
			<br/>
			<b>
			Why can't I use the easy method?
			</b>			
			<br/><br/>
			The preinstalled J2ME Enviorements on most Windows Mobile Phones dont have JSR-82 ( Bluetooth ) support. But this JSR-82 is important for the appropriate use of DUBwise - so we have to do more work ( which is described here ) to get a J2ME Envoirement on your windows mobile-phone which has JSR-82 support.
			You can check with the DUBwise Installer weather your phone has JSR-82 Support. If it complains at the beginning about a missing JSR-82 - this text is for you:
			<br/><br/>
			<b>Installation</b>
			<br/><br/>
<ul>
<li>
			Download the <a href="http://www.cs.kuleuven.be/~davy/phoneme/?q=node/10">phoneME Advanced Dual Stack - Foundation (with MIDP support) </a> for your Windows Mobile version ( the zip file )
</li>
<li>
			Download the <a href="downloads.jsp#windows_mobile"> DUBwise for Windows Mobile zip </a> for your screensize. Please note that the physical screensize of the device could be diffrent to the screensize PhoneME offers - if the images inside DUBwise are too small or to big - please try another zip.
</li>

<li>
			Create a folder "\Interner Speicher\DUBwise" on your phone ( you can take another name, but then you have to change the paths in DUBwise.lnk and start.txt. - there are no relative paths in windows mobile ... )
</li>
<li>
			Extract both zip files into this directory
</li>
<li>
			a double-click on DUBwise.lnk should start DUBwise now.
</li>



</ul>
		</div>

		</div>


<%@ include file="layout_s.jsp" %>   

