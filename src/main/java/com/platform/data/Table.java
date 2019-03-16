package com.platform.data;

import java.io.Serializable;
import java.util.List;

/**
 * 表
 */
public class Table implements Serializable {

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
