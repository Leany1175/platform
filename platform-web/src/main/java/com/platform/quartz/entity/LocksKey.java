package com.platform.quartz.entity;

import java.io.Serializable;

public class LocksKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String schedName;
    private String lockName;

    public LocksKey() {
    }

    public LocksKey(String schedName, String lockName) {
        this.schedName = schedName;
        this.lockName = lockName;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((schedName == null) ? 0 : schedName.hashCode());
        result = PRIME * result + ((lockName == null) ? 0 : lockName.hashCode());
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

        final LocksKey other = (LocksKey)obj;
        if(schedName == null){
            if(other.schedName != null){
                return false;
            }
        }else if(!schedName.equals(other.schedName)){
            return false;
        }
        if(lockName == null){
            if(other.lockName != null){
                return false;
            }
        }else if(!lockName.equals(other.lockName)){
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

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }
}
