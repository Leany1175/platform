package com.platform.quartz.repository;

import com.platform.quartz.entity.QuartzTriggers;
import com.platform.quartz.entity.TriggersKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriggersRepository extends JpaRepository<QuartzTriggers, TriggersKey> {



}
