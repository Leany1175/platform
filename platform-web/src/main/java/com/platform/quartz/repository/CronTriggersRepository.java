package com.platform.quartz.repository;

import com.platform.quartz.entity.QuartzCronTriggers;
import com.platform.quartz.entity.TriggersKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CronTriggersRepository extends JpaRepository<QuartzCronTriggers, TriggersKey> {



}
