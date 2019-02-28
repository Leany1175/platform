package com.platform.repository;

import com.platform.entity.quartz.FiredTriggersKey;
import com.platform.entity.quartz.QuartzFiredTriggers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiredTriggersRepository extends JpaRepository<QuartzFiredTriggers, FiredTriggersKey> {



}
