package com.platform.quartz.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 存储已配置的 触发器 (Trigger) 的信息
 */
@Entity
@Table(name = "qrtz_triggers")
@IdClass(TriggersKey.class)
public class QuartzTriggers implements Serializable {

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


    @Column(name = "job_name", length = 200, nullable = false)
    private String jobName;

    @Column(name = "job_group", length = 200, nullable = false)
    private String jobGroup;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "next_fire_time", length = 13)
    private BigDecimal nextFireTime;

    @Column(name = "prev_fire_time", length = 13)
    private BigDecimal prevFireTime;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "trigger_state", length = 16)
    private String triggerState;

    @Column(name = "trigger_type", length = 8)
    private String triggerType;

    @Column(name = "start_time", length = 13)
    private BigDecimal startTime;

    @Column(name = "end_time", length = 13)
    private BigDecimal endTime;

    @Column(name = "calendar_name", length = 200)
    private String calendarName;

    @Column(name = "misfire_instr", length = 2)
    private Short misfireInstr;

    @Column(name = "job_data", columnDefinition = "blob")
    private byte[] jobData;

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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(BigDecimal nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public BigDecimal getPrevFireTime() {
        return prevFireTime;
    }

    public void setPrevFireTime(BigDecimal prevFireTime) {
        this.prevFireTime = prevFireTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTriggerState() {
        return triggerState;
    }

    public void setTriggerState(String triggerState) {
        this.triggerState = triggerState;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public BigDecimal getStartTime() {
        return startTime;
    }

    public void setStartTime(BigDecimal startTime) {
        this.startTime = startTime;
    }

    public BigDecimal getEndTime() {
        return endTime;
    }

    public void setEndTime(BigDecimal endTime) {
        this.endTime = endTime;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public Short getMisfireInstr() {
        return misfireInstr;
    }

    public void setMisfireInstr(Short misfireInstr) {
        this.misfireInstr = misfireInstr;
    }

    public byte[] getJobData() {
        return jobData;
    }

    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }
}
