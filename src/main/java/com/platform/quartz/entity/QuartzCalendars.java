package com.platform.quartz.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 以 Blob 类型存储 Quartz 的 Calendar 信息
 */
@Entity
@Table(name = "qrtz_calendars")
@IdClass(CalendarsKey.class)
public class QuartzCalendars implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "sched_name", length = 120, nullable = false)
    private String schedName;

    @Id
    @Column(name = "calendar_name", length = 200, nullable = false)
    private String calendarName;

    @Column(name = "calendar")
    private String calendar;

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

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }
}
