package com.platform.quartz.repository;

import com.platform.quartz.entity.QuartzSimpleTriggers;
import com.platform.quartz.entity.TriggersKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleTriggersRepository extends JpaRepository<QuartzSimpleTriggers, TriggersKey> {



}
