package org.ligi.dubwise.download;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class DownloadSourceInfoRecord {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private Integer version_major;

    @Persistent
    private Integer version_minor;

    @Persistent
    private Integer version_patch;
    
    @Persistent
    private Date last_updated;

    public DownloadSourceInfoRecord (String version, Date last_updated) {

        this.last_updated = last_updated;
    }


}
