package org.ligi.dubwise.download;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;
import com.google.appengine.api.datastore.Text;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class PersistentDevice {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private Date date;

    @Persistent 
    private String user_agent;

    @Persistent 
    private String browser_user_agent;

    @Persistent
    private String platform;

    @Persistent
    private String encoding;

    @Persistent
    private String locale;

    @Persistent
    private String configuration;

    @Persistent
    private String profiles;

    @Persistent
    private String hostname;

    @Persistent
    private String location_api_version;

    @Persistent
    private String sensor_api_version;
  
    @Persistent
    private Text comports;

    @Persistent
    private Integer canvas_width;

    @Persistent
    private Integer canvas_height;

    @Persistent
    private Integer canvas_full_width;

    @Persistent    
    private Integer canvas_full_height;

    @Persistent
    private Integer rms_avail;

    @Persistent
    private Long total_mem;

    @Persistent
    private Long free_mem;

    @Persistent
    private Boolean locationprovider;

    @Persistent
    private Boolean devicecontrol;

    @Persistent
    private Boolean bluetooth;

    @Persistent
    private Boolean cldc11;

    @Persistent
    private Boolean fileapi;

    @Persistent
    private Boolean sensorapi;
    
    @Persistent
    private Boolean symbian;

    @Persistent
    private Boolean jsr179;

    @Persistent
    private Boolean snd_wav;

    @Persistent
    private Text protocol_types;	
    
    
    public String getProtocolTypes() {
	return protocol_types.getValue();
	}


    public void setProtocolTypes(String protocolTypes) {
	
	try 
	    {
		protocol_types = new Text(protocolTypes);
	    }
	catch (Exception e)
	    {
		protocol_types=new Text("");
	    }
	protocol_types=new Text("");
    }


	public Boolean getSnd_wav() {
		return snd_wav;
	}


	public void setSnd_wav(Boolean sndWav) {
		snd_wav = sndWav;
	}


	public Boolean getSnd_mp3_16kbit() {
		return snd_mp3_16kbit;
	}


	public void setSnd_mp3_16kbit(Boolean sndMp3_16kbit) {
		snd_mp3_16kbit = sndMp3_16kbit;
	}


	public Boolean getSnd_mp3_32kbit() {
		return snd_mp3_32kbit;
	}


	public void setSnd_mp3_32kbit(Boolean sndMp3_32kbit) {
		snd_mp3_32kbit = sndMp3_32kbit;
	}


	public Boolean getSnd_mp3_64kbit() {
		return snd_mp3_64kbit;
	}


	public void setSnd_mp3_64kbit(Boolean sndMp3_64kbit) {
		snd_mp3_64kbit = sndMp3_64kbit;
	}




	@Persistent
    private Boolean snd_mp3_16kbit;

    @Persistent
    private Boolean snd_mp3_32kbit;

    @Persistent
    private Boolean snd_mp3_64kbit;


    public PersistentDevice( Date date,String user_agent) {
        this.date = date;
	this.user_agent = user_agent;
    }

    
    public Long getId() {
	return id;
    }
    
    public void setId(Long id) {
	this.id = id;
    }
    
    public Date getDate() {
	return date;
    }
    
    public void setDate(Date date) {
	this.date = date;
    }
    
    public String getUserAagent() {
	return user_agent;
    }
    
    public void setUserAgent(String user_agent) {
	this.user_agent = user_agent;
    }
    
    
    
    public String getPlatform() {
	return platform;
    }
    
    public void setPlatform(String platform) {
	this.platform = platform;
    }
    
    public String getEncoding() {
	return encoding;
    }
    
    public void setEncoding(String encoding) {
	this.encoding = encoding;
    }
    
    public String getLocale() {
	return locale;
    }
    
    public void setLocale(String locale) {
	this.locale = locale;
    }
    
    public String getConfiguration() {
	return configuration;
    }
    
    public void setConfiguration(String configuration) {
	this.configuration = configuration;
    }
    
    public String getProfiles() {
	return profiles;
    }
    
    public void setProfiles(String profiles) {
	this.profiles = profiles;
    }
    
    public String getHostname() {
	return hostname;
    }
    
    public void setHostname(String hostname) {
	this.hostname = hostname;
    }
    
    public String getLocation_api_version() {
	return location_api_version;
    }
    
    public void setLocation_api_version(String location_api_version) {
	this.location_api_version = location_api_version;
    }
 
    public String getSensor_api_version() {
	return sensor_api_version;
    }

    public void setSensor_api_version(String sensor_api_version) {
	this.sensor_api_version = sensor_api_version;
    }

    public String getComPorts() {
	return comports.getValue();
    }

    public void setComPorts(String comports) {

	    try 
		{
		    this.comports = new Text(comports);
		}
	    catch (Exception e)
		{
		    this.comports = new Text("");
		}
	    this.comports = new Text("");
    }


    public int getCanvas_width() {
	return canvas_width;
    }

    public void setCanvas_width(int canvas_width) {
	this.canvas_width = canvas_width;
    }

    public int getCanvas_height() {
	return canvas_height;
    }

    public void setCanvas_height(int canvas_height) {
	this.canvas_height = canvas_height;
    }

    public int getCanvas_full_width() {
	return canvas_full_width;
    }

    public void setCanvas_full_width(int canvas_full_width) {
	this.canvas_full_width = canvas_full_width;
    }

    public int getCanvas_full_height() {
	return canvas_full_height;
    }

    public void setCanvas_full_height(int canvas_full_height) {
	this.canvas_full_height = canvas_full_height;
    }

    public boolean isLocationprovider() {
	return locationprovider;
    }

    public void setLocationprovider(boolean locationprovider) {
	this.locationprovider = locationprovider;
    }

    public boolean isDeviceControl() {
	return devicecontrol;
    }

    public void setDeviceControl(boolean devicecontrol) {
	this.devicecontrol = devicecontrol;
    }

    public boolean isBluetooth() {
	return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
	this.bluetooth = bluetooth;
    }

    public boolean isCldc11() {
	return cldc11;
    }

    public void setCldc11(boolean cldc11) {
	this.cldc11 = cldc11;
    }

    public boolean isFileAPI() {
	return fileapi;
    }


    public void setJSR179(boolean jsr179) {
	this.jsr179 = jsr179;
    }

    public boolean isJSR179() {
	return jsr179;
    }


    public void setFileAPI(boolean fileapi) {
	this.fileapi = fileapi;
    }

    public boolean isSensorAPI() {
	return sensorapi;
    }

    public void setSensorAPI(boolean sensorapi) {
	this.sensorapi = sensorapi;
    }

    public boolean isSymbian() {
	return symbian;
    }

    public void setSymbian(boolean symbian) {
	this.symbian = symbian;
    }


    public void setFreeMem(long free_mem)
    {
	this.free_mem=free_mem;
    }

    public long getFreeMem()
    {
	return free_mem;
    }


    public void setTotalMem(long total_mem)
    {
	this.total_mem=total_mem;
    }

    public long getTotalMem()
    {
	return total_mem;
    }


    public void setRMSAvail(int rms_avail)
    {
	this.rms_avail=rms_avail;
    }

    public long getRMSAvail()
    {
	return rms_avail;
    }

    public String comports_str()
    {
	try 
	    {
		// thre replacement gives the possibility to display on multiple lines - e.g. Nokia has long comport lists sometimes
		return (""+comports).replace(",",", ");
	    }
	catch (Exception e)
	    {
		// there was a problem migrating from String to Text
		return "old format";
	    }
    }

    public String[][] info_array()
    {
	return new String[][]
	    { 
		{"ID",""+id },
		{"Platform",platform },
		{"j2me_user_agent",user_agent},
		{"browser_user_agent",browser_user_agent },
	        {"encoding",encoding},
		{"locale",locale},
		{"configuration",configuration},
		{"profiles",profiles},
		{"hostname",hostname},
		{"location_api_version",location_api_version},
		{"sensor_api_version",sensor_api_version},
		{"comports",comports_str()}, 
		{"canvas_width",""+canvas_width},
		{"canvas_height",""+canvas_height},
		{"canvas_full_width",""+canvas_full_width},
		{"canvas_full_height",""+canvas_full_height},
		{"rms_avail",""+rms_avail},
		{"free_mem",""+free_mem},
		{"total_mem",""+total_mem},
		{"symbian",""+symbian},
		{"sensorapi",""+sensorapi},
		{"fileapi",""+fileapi},
		{"cldc11",""+cldc11},
		{"bluetooth",""+bluetooth},
		{"devicecontrol",""+devicecontrol},
		{"jsr179",""+jsr179},
		{"snd_wav",""+snd_wav},
		{"snd_mp3_16kbit",""+snd_mp3_16kbit},
		{"snd_mp3_32kbit",""+snd_mp3_32kbit},
		{"snd_mp3_64kbit",""+snd_mp3_64kbit},
		{"Protocol types",""+protocol_types}
	    };
    }
	

    public String info_text()
    {
	String res="";
	String[][] info_arr=info_array();

	for ( int i =0;i<info_arr.length;i++)
	    res+=info_arr[i][0] + " = " + info_arr[i][1] + "\n";
	return res;
	   
    }


	public void setBrowserUserAgent(String browser_user_agent) {
		this.browser_user_agent  =  browser_user_agent;
	}


	public String getBrowserUserAgent() {
		return browser_user_agent;
	}


}
