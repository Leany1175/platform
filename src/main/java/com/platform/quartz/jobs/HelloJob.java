package com.platform.quartz.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

@DisallowConcurrentExecution
public class HelloJob implements Job {

	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println(sdf.format(new Date()));
	}

}
