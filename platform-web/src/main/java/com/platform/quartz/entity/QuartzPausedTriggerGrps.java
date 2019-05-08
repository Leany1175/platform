package com.platform.quartz.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 存储已暂停的 Trigger 组的信息
 */
@Entity
@Table(name = "qrtz_paused_trigger_grps")
@IdClass(PausedTriggerGrpsKey.class)
public class QuartzPausedTriggerGrps implements Serializable {

	private static final long serialVersionUID = 1L;

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
