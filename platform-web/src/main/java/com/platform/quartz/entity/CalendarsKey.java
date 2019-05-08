package com.platform.quartz.entity;

import java.io.Serializable;

public class CalendarsKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String schedName;
    private String calendarName;

    public CalendarsKey() {
    }

    public CalendarsKey(String schedName, String calendarName) {
        this.schedName = schedName;
        this.calendarName = calendarName;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((schedName == null) ? 0 : schedName.hashCode());
        result = PRIME * result + ((calendarName == null) ? 0 : calendarName.hashCode());
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

        final CalendarsKey other = (CalendarsKey)obj;
        if(schedName == null){
            if(other.schedName != null){
                return false;
            }
        }else if(!schedName.equals(other.schedName)){
            return false;
        }
        if(calendarName == null){
            if(other.calendarName != null){
                return false;
            }
        }else if(!calendarName.equals(other.calendarName)){
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

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }
}
