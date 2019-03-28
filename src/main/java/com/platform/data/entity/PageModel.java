package com.platform.data.entity;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 分页模型
 */
public class PageModel<T> {
	
	/** 当前页号 */
	private int currentPage = 1;
	/** 每页显示条数 */
	private int size = 10;
	/** 当前页展示数据 */
	private List<T> list;
	/** 总条数 */
	private int count;
	/** 总页数 */
	private int sumPage;
	
	public PageModel() {
		super();
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		this.sumPage = this.count % this.size == 0 ? this.count / this.size : this.count / this.size + 1;
	}
	public int getSumPage() {
		return sumPage;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
