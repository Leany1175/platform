package com.platform.quartz.controller;

import com.platform.controller.AdminBaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
@RequestMapping("/admin/job")
public class JobController {

	private static Logger logger = LoggerFactory.getLogger(JobController.class);

	/**
	 * 任务管理界面
	 * @return 路径
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page() {
		return "admin/job/job-manager";
	}

}
