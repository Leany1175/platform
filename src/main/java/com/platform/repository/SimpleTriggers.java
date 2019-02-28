package com.platform.repository;

import com.platform.entity.quartz.QuartzSimpleTriggers;
import com.platform.entity.quartz.TriggersKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleTriggers extends JpaRepository<QuartzSimpleTriggers, TriggersKey> {



}
