package com.platform.repository;

import com.platform.entity.quartz.QuartzSchedulerState;
import com.platform.entity.quartz.SchedulerStateKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerStateRepository extends JpaRepository<QuartzSchedulerState, SchedulerStateKey> {



}
