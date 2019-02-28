package com.platform.listener;

import com.platform.quartz.jobs.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebContainerListener implements ServletContextListener {

	private static Logger logger = LoggerFactory.getLogger(WebContainerListener.class);

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		logger.info("web - contextInitialized");
		try {
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.start();

			// 任务
			JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job-name", "job-group").build();
			// 触发器
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger-name", "trigger-group").withSchedule(
					SimpleScheduleBuilder.repeatSecondlyForever(3).repeatForever()).build();

//			scheduler.scheduleJob(jobDetail, trigger);

		} catch (SchedulerException e) {
			logger.error("quatz start faild", e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		logger.info("web - contextDestroyed");
	}
}
