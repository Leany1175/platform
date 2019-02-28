package com.platform.entity.quartz;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "qrtz_paused_trigger_grps")
@IdClass(PausedTriggerGrpsKey.class)
public class QuartzPausedTriggerGrps implements Serializable {

    @Id
    @Column(name = "sched_name", length = 120, nullable = false)
    private String schedName;

    @Id
    @Column(name = "trigger_group", length = 200, nullable = false)
    private String triggerGroup;

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }
}
