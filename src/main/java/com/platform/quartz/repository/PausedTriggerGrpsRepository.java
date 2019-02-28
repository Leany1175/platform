package com.platform.quartz.repository;

import com.platform.quartz.entity.PausedTriggerGrpsKey;
import com.platform.quartz.entity.QuartzPausedTriggerGrps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PausedTriggerGrpsRepository extends JpaRepository<QuartzPausedTriggerGrps, PausedTriggerGrpsKey> {



}
