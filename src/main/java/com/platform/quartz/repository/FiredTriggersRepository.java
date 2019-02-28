package com.platform.quartz.repository;

import com.platform.quartz.entity.FiredTriggersKey;
import com.platform.quartz.entity.QuartzFiredTriggers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiredTriggersRepository extends JpaRepository<QuartzFiredTriggers, FiredTriggersKey> {



}
