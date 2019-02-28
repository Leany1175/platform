package com.platform.quartz.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * qrtz_simple_triggers
 */
@Entity
@Table(name = "qrtz_simple_triggers")
@IdClass(TriggersKey.class)
public class QuartzSimpleTriggers implements Serializable {

    @Id
    @Column(name = "sched_name", length = 120, nullable = false)
    private String schedName;

    @Id
    @Column(name = "trigger_name", length = 200, nullable = false)
    private String triggerName;

    @Id
    @Column(name = "trigger_group", length = 200, nullable = false)
    private String triggerGroup;

    @Column(name = "repeat_count", length = 7, nullable = false)
    private BigDecimal repeatCount;

    @Column(name = "repeat_interval", length = 12, nullable = false)
    private BigDecimal repeatInterval;

    @Column(name = "times_triggered", length = 10, nullable = false)
    private BigDecimal timesTriggered;

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public BigDecimal getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(BigDecimal repeatCount) {
        this.repeatCount = repeatCount;
    }

    public BigDecimal getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(BigDecimal repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public BigDecimal getTimesTriggered() {
        return timesTriggered;
    }

    public void setTimesTriggered(BigDecimal timesTriggered) {
        this.timesTriggered = timesTriggered;
    }
}
