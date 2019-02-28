package com.platform.repository;

import com.platform.entity.quartz.QuartzTriggers;
import com.platform.entity.quartz.TriggersKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriggersRepository extends JpaRepository<QuartzTriggers, TriggersKey> {



}
