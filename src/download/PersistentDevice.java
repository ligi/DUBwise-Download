package org.ligi.dubwise.download;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

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
    private String comports;

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
	return comports;
    }

    public void setComPorts(String comports) {
	this.comports = comports;
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




    public String info_text()
    {
	return 
	    "\nID="+id+
	    "\nencoding="+encoding+
	    "\nplatform="+platform+
	    "\nlocale="+locale+
	    "\nconfiguration="+configuration+
	    "\nprofiles="+profiles+
	    "\nhostname="+hostname+
	    "\nlocation_api_version="+location_api_version+
	    "\nsensor_api_version="+sensor_api_version+
	    "\ncomports="+comports+
	    "\ncanvas_width="+""+canvas_width+
	    "\ncanvas_height="+""+canvas_height+
	    "\ncanvas_full_width="+""+canvas_full_width+
	    "\ncanvas_full_height="+""+canvas_full_height+
	    "\nrms_avail="+""+rms_avail+
	    "\nfree_mem="+""+free_mem+
	    "\ntotal_mem="+""+total_mem+
	    "\nsymbian="+symbian+
	    "\nsensorapi="+sensorapi+
	    "\nfileapi="+fileapi+
	    "\ncldc11="+cldc11+
	    "\nbluetooth="+bluetooth+
	    "\ndevicecontrol="+devicecontrol+
	    "\njsr179="+jsr179+
	    "\nsnd_wav="+snd_wav+
	    "\nsnd_mp3_16kbit="+nd_mp3_16kbit+
	    "\nsnd_mp3_32kbit="+nd_mp3_32kbit+
	    "\nsnd_mp3_64kbit="+nd_mp3_64kbit+
	    "";
    }


}
