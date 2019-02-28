package com.platform.quartz.repository;

import com.platform.quartz.entity.CalendarsKey;
import com.platform.quartz.entity.QuartzCalendars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarsRepository extends JpaRepository<QuartzCalendars, CalendarsKey> {



}
