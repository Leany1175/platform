package com.platform.quartz.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 存储 Cron Trigger，包括 Cron 表达式和时区信息
 */
@Entity
@Table(name = "qrtz_cron_triggers")
@IdClass(TriggersKey.class)
public class QuartzCronTriggers implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "sched_name", length = 120, nullable = false)
    private String schedName;

    @Id
    @Column(name = "trigger_name", length = 200, nullable = false)
    private String triggerName;

    @Id
    @Column(name = "trigger_group", length = 200, nullable = false)
    private String triggerGroup;

    @Column(name = "cron_expression", length = 200, nullable = false)
    private String cronExpression;

    @Column(name = "time_zone_id", length = 80)
    private String timeZoneId;

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

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }
}
