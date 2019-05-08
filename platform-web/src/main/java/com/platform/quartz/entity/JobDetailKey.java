package com.platform.quartz.entity;

import java.io.Serializable;

/**
 * 联合主键
 */
public class JobDetailKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String schedName;
    private String jobName;
    private String jobGroup;

    public JobDetailKey() {
    }

    public JobDetailKey(String schedName, String jobName, String jobGroup) {
        this.schedName = schedName;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((schedName == null) ? 0 : schedName.hashCode());
        result = PRIME * result + ((jobName == null) ? 0 : jobName.hashCode());
        result = PRIME * result + ((jobGroup == null) ? 0 : jobGroup.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        final JobDetailKey other = (JobDetailKey)obj;
        if(schedName == null){
            if(other.schedName != null){
                return false;
            }
        }else if(!schedName.equals(other.schedName)){
            return false;
        }
        if(jobName == null){
            if(other.jobName != null){
                return false;
            }
        }else if(!jobName.equals(other.jobName)){
            return false;
        }
        if(jobGroup == null){
            if(other.jobGroup != null){
                return false;
            }
        }else if(!jobGroup.equals(other.jobGroup)){
            return false;
        }
        return true;
    }

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
}
