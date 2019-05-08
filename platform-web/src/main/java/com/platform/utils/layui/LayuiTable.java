package com.platform.utils.layui;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * layui表单接收数据
 */
public class LayuiTable implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/** 当前页 */
	private Integer page = 1;
	/** 默认条数 */
	private Integer limit = 10;

	public LayuiTable() {
	}

	public LayuiTable(Integer page, Integer limit) {
		this.page = page;
		this.limit = limit;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
