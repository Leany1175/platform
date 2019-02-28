package com.platform.repository;

import com.platform.entity.quartz.QuartzCronTriggers;
import com.platform.entity.quartz.TriggersKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CronTriggersRepository extends JpaRepository<QuartzCronTriggers, TriggersKey> {



}
