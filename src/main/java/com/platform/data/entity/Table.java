package com.platform.data.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 表
 */
public class Table implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 表名 */
	private String name;
	/** 列 */
	private List<Column> columnList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}
}
