package com.platform.entity.quartz;

import java.io.Serializable;

public class FiredTriggersKey implements Serializable {

    private String schedName;
    private String entryId;

    public FiredTriggersKey() {
    }

    public FiredTriggersKey(String schedName, String entryId) {
        this.schedName = schedName;
        this.entryId = entryId;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((schedName == null) ? 0 : schedName.hashCode());
        result = PRIME * result + ((entryId == null) ? 0 : entryId.hashCode());
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

        final FiredTriggersKey other = (FiredTriggersKey)obj;
        if(schedName == null){
            if(other.schedName != null){
                return false;
            }
        }else if(!schedName.equals(other.schedName)){
            return false;
        }
        if(entryId == null){
            if(other.entryId != null){
                return false;
            }
        }else if(!entryId.equals(other.entryId)){
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

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }
}
