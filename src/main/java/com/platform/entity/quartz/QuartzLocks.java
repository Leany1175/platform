package com.platform.entity.quartz;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "qrtz_locks")
@IdClass(LocksKey.class)
public class QuartzLocks implements Serializable {

    @Id
    @Column(name = "sched_name", length = 120, nullable = false)
    private String schedName;

    @Id
    @Column(name = "lock_name", length = 40, nullable = false)
    private String lockName;

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }
}
