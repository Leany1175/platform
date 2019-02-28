package com.platform.repository;

import com.platform.entity.quartz.CalendarsKey;
import com.platform.entity.quartz.QuartzCalendars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarsRepository extends JpaRepository<QuartzCalendars, CalendarsKey> {



}
