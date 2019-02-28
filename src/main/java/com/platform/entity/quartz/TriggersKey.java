package com.platform.entity.quartz;

import java.io.Serializable;

public class TriggersKey implements Serializable {

    private String schedName;
    private String triggerName;
    private String triggerGroup;

    public TriggersKey() {
    }

    public TriggersKey(String schedName, String triggerName, String triggerGroup) {
        this.schedName = schedName;
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((schedName == null) ? 0 : schedName.hashCode());
        result = PRIME * result + ((triggerName == null) ? 0 : triggerName.hashCode());
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

        final TriggersKey other = (TriggersKey) obj;
        if(schedName == null){
            if(other.triggerName != null){
                return false;
            }
        }else if(!schedName.equals(other.triggerName)){
            return false;
        }
        if(triggerName == null){
            if(other.triggerName != null){
                return false;
            }
        }else if(!triggerName.equals(other.triggerName)){
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
}
