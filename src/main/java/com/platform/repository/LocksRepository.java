package com.platform.repository;

import com.platform.entity.quartz.LocksKey;
import com.platform.entity.quartz.QuartzLocks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocksRepository extends JpaRepository<QuartzLocks, LocksKey> {



}
