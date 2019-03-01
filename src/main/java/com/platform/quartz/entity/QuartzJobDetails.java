package com.platform.quartz.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 存储每一个已配置的 Job 的详细信息(jobDetail)
 */
@Entity
@Table(name = "qrtz_job_details")
@IdClass(JobDetailKey.class)
public class QuartzJobDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "sched_name", length = 120, nullable = false)
    private String schedName;

    @Id
    @Column(name = "job_name", length = 200, nullable = false)
    private String jobName;

    @Id
    @Column(name = "job_group", length = 200, nullable = false)
    private String jobGroup;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "job_class_name", length = 250, nullable = false)
    private String jobClassName;

    @Column(name = "is_durable", length = 1, nullable = false)
    private String isDurable;

    @Column(name = "is_nonconcurrent", length = 1, nullable = false)
    private String isNonconcurrent;

    @Column(name = "is_update_data", length = 1, nullable = false)
    private String isUpdateData;

    @Column(name = "requests_recovery", length = 1, nullable = false)
    private String requestsRecovery;

    @Column(name = "job_data", columnDefinition = "blob")
    private byte[] jobData;

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
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

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getIsDurable() {
        return isDurable;
    }

    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable;
    }

    public String getIsNonconcurrent() {
        return isNonconcurrent;
    }

    public void setIsNonconcurrent(String isNonconcurrent) {
        this.isNonconcurrent = isNonconcurrent;
    }

    public String getIsUpdateData() {
        return isUpdateData;
    }

    public void setIsUpdateData(String isUpdateData) {
        this.isUpdateData = isUpdateData;
    }

    public String getRequestsRecovery() {
        return requestsRecovery;
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
    }

    public byte[] getJobData() {
        return jobData;
    }

    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }
}
