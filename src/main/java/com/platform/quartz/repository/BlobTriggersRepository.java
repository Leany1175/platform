package com.platform.quartz.repository;

import com.platform.quartz.entity.QuartzBlobTriggers;
import com.platform.quartz.entity.TriggersKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlobTriggersRepository extends JpaRepository<QuartzBlobTriggers, TriggersKey> {



}
