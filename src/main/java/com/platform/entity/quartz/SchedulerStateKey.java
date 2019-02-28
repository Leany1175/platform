package com.platform.entity.quartz;

import java.io.Serializable;

public class SchedulerStateKey implements Serializable {

    private String schedName;
    private String instanceName;

    public SchedulerStateKey() {
    }

    public SchedulerStateKey(String schedName, String instanceName) {
        this.schedName = schedName;
        this.instanceName = instanceName;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((schedName == null) ? 0 : schedName.hashCode());
        result = PRIME * result + ((instanceName == null) ? 0 : instanceName.hashCode());
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

        final SchedulerStateKey other = (SchedulerStateKey)obj;
        if(schedName == null){
            if(other.schedName != null){
                return false;
            }
        }else if(!schedName.equals(other.schedName)){
            return false;
        }
        if(instanceName == null){
            if(other.instanceName != null){
                return false;
            }
        }else if(!instanceName.equals(other.instanceName)){
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

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }
}
