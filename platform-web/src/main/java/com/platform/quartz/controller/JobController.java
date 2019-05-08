package com.platform.quartz.controller;

import com.platform.quartz.entity.QuartzJobDetails;
import com.platform.quartz.service.JobDetaiService;
import com.platform.utils.layui.LayuiEntity;
import com.platform.utils.layui.LayuiTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("/admin/job")
public class JobController {

	private static Logger logger = LoggerFactory.getLogger(JobController.class);

	@Autowired
	private JobDetaiService jobDetaiService;

	/**
	 * 任务管理界面
	 * @return 路径
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page() {
		return "admin/job/job-manager";
	}

	/**
	 * 任务列表
	 */
	@ResponseBody
	@RequestMapping(value = "/datalist", method = RequestMethod.GET)
	public LayuiEntity<QuartzJobDetails> datalist(LayuiTable table) {
		logger.info("任务列表");
		return jobDetaiService.findPage(table);
	}

	/**
	 * 添加任务页面
	 * @return 页面路径
	 */
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String addPage() {
		return "admin/job/job-add";
	}

}
