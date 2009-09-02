package org.ligi.dubwise.download;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class PersistentUniqueDevice {
    @PrimaryKey
  //  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  //  private Long id;

   // @Key
    @Persistent
    private String platform;
    
    @Persistent
    private Long example_device_id;
    
    public PersistentUniqueDevice(String platform, Long example_device_id) {
    		this.setPlatform(platform);
    		this.setExampleDeviceId(example_device_id);
    }
/*
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
*/
	public void setExampleDeviceId(Long example_device_id) {
		this.example_device_id = example_device_id;
	}

	public Long getExampleDeviceId() {
		return example_device_id;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatform() {
		return platform;
	}



}
