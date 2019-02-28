package com.platform.repository;

import com.platform.entity.quartz.PausedTriggerGrpsKey;
import com.platform.entity.quartz.QuartzPausedTriggerGrps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PausedTriggerGrpsRepository extends JpaRepository<QuartzPausedTriggerGrps, PausedTriggerGrpsKey> {



}
