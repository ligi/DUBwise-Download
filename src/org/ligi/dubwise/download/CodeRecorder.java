package org.ligi.dubwise.download;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class CodeRecorder {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private String code;

    @Persistent
    private Date date;

    @Persistent 
    private String user_agent;

    public CodeRecorder( String code, Date date,String user_agent) {
        this.code = code;
        this.date = date;
	this.user_agent = user_agent;
    }

    public Long getId() {
        return id;
    }


    public String getCode() {
        return code;
    }

    public String getUserAgent() {
        return user_agent;
    }

    public Date getDate() {
        return date;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public void setUserAgent(String agent) {
        this.user_agent = agent;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
