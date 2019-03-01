package com.platform.quartz.entity;

import java.io.Serializable;

public class PausedTriggerGrpsKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String schedName;
    private String triggerGroup;

    public PausedTriggerGrpsKey() {
    }

    public PausedTriggerGrpsKey(String schedName, String triggerGroup) {
        this.schedName = schedName;
        this.triggerGroup = triggerGroup;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((schedName == null) ? 0 : schedName.hashCode());
        result = PRIME * result + ((triggerGroup == null) ? 0 : triggerGroup.hashCode());
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

        final PausedTriggerGrpsKey other = (PausedTriggerGrpsKey)obj;
        if(schedName == null){
            if(other.schedName != null){
                return false;
            }
        }else if(!schedName.equals(other.schedName)){
            return false;
        }
        if(triggerGroup == null){
            if(other.triggerGroup != null){
                return false;
            }
        }else if(!triggerGroup.equals(other.triggerGroup)){
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

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }
}
