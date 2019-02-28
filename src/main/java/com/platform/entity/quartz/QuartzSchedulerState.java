package com.platform.entity.quartz;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "qrtz_scheduler_state")
@IdClass(SchedulerStateKey.class)
public class QuartzSchedulerState implements Serializable {

    @Id
    @Column(name = "sched_name", length = 120, nullable = false)
    private String schedName;

    @Id
    @Column(name = "instance_name", length = 120, nullable = false)
    private String instanceName;

    @Column(name = "last_checkin_time", length = 13, nullable = false)
    private BigDecimal lastCheckinTime;

    @Column(name = "checkin_interval", length = 13, nullable = false)
    private BigDecimal checkinInterval;

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public BigDecimal getLastCheckinTime() {
        return lastCheckinTime;
    }

    public void setLastCheckinTime(BigDecimal lastCheckinTime) {
        this.lastCheckinTime = lastCheckinTime;
    }

    public BigDecimal getCheckinInterval() {
        return checkinInterval;
    }

    public void setCheckinInterval(BigDecimal checkinInterval) {
        this.checkinInterval = checkinInterval;
    }
}
