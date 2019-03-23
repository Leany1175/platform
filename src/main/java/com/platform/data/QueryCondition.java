package com.platform.data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.platform.data.builder.ConditionBean;

/**
 * 查询条件
 */
public class QueryCondition implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 是否分页 */
	private boolean isPage = true;
	/** 表名 */
	private String tableName;
	/** 查询字段 */
	private List<String> fieldList = new LinkedList<>();
	/** 当前页,默认为1 */
	private int pageNo = 1;
	/** 条数,默认为10 */
	private int size = 10;
	/** 查询条件 */
	private List<ConditionBean> conditionList = new LinkedList<>();
	/** 排序条件 */
	private List<ConditionBean> orderList = new LinkedList<>();

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean page) {
		isPage = page;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<String> fieldList) {
		this.fieldList = fieldList;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<ConditionBean> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<ConditionBean> conditionList) {
		this.conditionList = conditionList;
	}

	public List<ConditionBean> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ConditionBean> orderList) {
		this.orderList = orderList;
	}
}
