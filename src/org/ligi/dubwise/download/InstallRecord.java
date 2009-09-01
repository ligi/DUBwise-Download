package org.ligi.dubwise.download;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class InstallRecord {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private String code;
    
    @Persistent
    private Long device_id;

    @Persistent
    private String install_result;

    @Persistent
    private String delete_result;


    @Persistent
    private String installer_source;

    
    @Persistent
    private Date date;

    public InstallRecord(String code, Date date,Long device_id) {
	this.code = code;
	this.device_id=device_id;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }




    public Long getDeviceId()
    {
	return device_id;
    }

    public void setDeviceId(Long device_id)
    {
	this.device_id=device_id;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }


    public void setInstallResult(String install_result) {
        this.install_result=install_result;
    }

    public String getInstallResult() {
        return install_result;
    }


    public void setDeleteResult(String delete_result) {
        this.delete_result=delete_result;
    }

    public String getDeleteResult() {
        return delete_result;
    }

	public void setInstallerSource(String installer_source) {
		this.installer_source = installer_source;
	}

	public String getInstallerSource() {
		return installer_source;
	}



}
