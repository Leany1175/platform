package com.platform.utils.layui;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * layui 表格数据
 */
public class LayuiEntity<T> {
	
	/** code */
	private Integer code = 0;
	/** 消息 */
	private String msg = "分页查询";
	/** 总条数 */
	private Integer count;
	/** 数据 */
	private List<T> data;
	
	public LayuiEntity(){}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public LayuiEntity(int count, List<T> data){
		this.count = count;
		this.data = data;
	}
	
	public LayuiEntity(long count, List<T> data){
		this.count = (int) count;
		this.data = data;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
