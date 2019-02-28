package com.platform.quartz.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * qrtz_blog_triggers
 */
@Entity
@Table(name = "qrtz_blob_triggers")
@IdClass(TriggersKey.class)
public class QuartzBlobTriggers implements Serializable {

    @Id
    @Column(name = "sched_name", length = 120, nullable = false)
    private String schedName;

    @Id
    @Column(name = "trigger_name", length = 200, nullable = false)
    private String triggerName;

    @Id
    @Column(name = "trigger_group", length = 200, nullable = false)
    private String triggerGroup;

    @Column(name = "blob_data", columnDefinition = "blob")
    private byte[] blobData;

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

	public byte[] getBlobData() {
		return blobData;
	}

	public void setBlobData(byte[] blobData) {
		this.blobData = blobData;
	}
}
