package com.platform.quartz.repository;

import com.platform.quartz.entity.LocksKey;
import com.platform.quartz.entity.QuartzLocks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocksRepository extends JpaRepository<QuartzLocks, LocksKey> {



}
