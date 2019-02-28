package com.platform.quartz.repository;

import com.platform.quartz.entity.QuartzSchedulerState;
import com.platform.quartz.entity.SchedulerStateKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerStateRepository extends JpaRepository<QuartzSchedulerState, SchedulerStateKey> {



}
