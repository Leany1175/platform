package com.platform.entity.quartz;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 存储与已触发的 Trigger 相关的状态信息，以及相联 Job 的执行信息
 */
@Entity
@Table(name = "qrtz_fired_triggers")
@IdClass(FiredTriggersKey.class)
public class QuartzFiredTriggers implements Serializable {

    @Id
    @Column(name = "sched_name", length = 120, nullable = false)
    private String schedName;

    @Id
    @Column(name = "entry_id", length = 95, nullable = false)
    private String entryId;

    @Column(name = "trigger_name", length = 200, nullable = false)
    private String triggerName;

    @Column(name = "trigger_group", length = 200, nullable = false)
    private String triggerGroup;

    @Column(name = "instance_name", length = 200, nullable = false)
    private String instanceName;

    @Column(name = "fired_time", length = 13, nullable = false)
    private BigDecimal firedTime;

    @Column(name = "sched_time", length = 13, nullable = false)
    private BigDecimal schedTime;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @Column(name = "state", length = 16, nullable = false)
    private String state;

    @Column(name = "job_name", length = 200, nullable = false)
    private String jobName;

    @Column(name = "job_group", length = 200, nullable = false)
    private String jobGroup;

    @Column(name = "is_nonconcurrent", length = 1, nullable = false)
    private String isNonconcurrent;

    @Column(name = "requests_recovery", length = 1, nullable = false)
    private String requestsRecovery;

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
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

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public BigDecimal getFiredTime() {
        return firedTime;
    }

    public void setFiredTime(BigDecimal firedTime) {
        this.firedTime = firedTime;
    }

    public BigDecimal getSchedTime() {
        return schedTime;
    }

    public void setSchedTime(BigDecimal schedTime) {
        this.schedTime = schedTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getIsNonconcurrent() {
        return isNonconcurrent;
    }

    public void setIsNonconcurrent(String isNonconcurrent) {
        this.isNonconcurrent = isNonconcurrent;
    }

    public String getRequestsRecovery() {
        return requestsRecovery;
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
    }
}
