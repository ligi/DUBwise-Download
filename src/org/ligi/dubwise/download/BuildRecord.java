package org.ligi.dubwise.download;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Text;
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class BuildRecord {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private String code;

    @Persistent
    private Date date;

    @Persistent 
    private Blob jar;

    @Persistent 
    private Text jad;

    @Persistent
    private boolean update_flag=false;

    public BuildRecord( String code, Date date,Blob jar,Text jad) {
        this.code = code;
        this.date = date;
	this.jar = jar;
	this.jad = jad;
    }

    public Long getId() {
        return id;
    }


    public Blob getJAR()
    {
	return jar;
    }
    
    public Text getJad()
    {
	return jad;
    }

    public void setJAR(Blob jar)
    {
	this.jar=jar;
    }
    
    public void setJAD(Text jad)
    {
	this.jad=jad;
    }


    public void setUpdateFlag(boolean flag)
    {
	this.update_flag=flag;
    }
    public String getCode() {
        return code;
    }

    public Date getDate() {
        return date;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
