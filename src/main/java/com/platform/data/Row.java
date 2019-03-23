package com.platform.data;

import java.math.BigDecimal;
import java.util.*;

public class Row extends HashMap<Column, Object> {

	private static final long serialVersionUID = 1L;

	/**
	 * 获取所有列的列名
	 * @return 列名集合
	 */
	public List<String> keysString(){
		// 列集合
		Set<Column> columnSet = keySet();
		List<String> nameList = new ArrayList<>(columnSet.size());
		columnSet.forEach(column -> nameList.add(column.getName()));
		return nameList;
	}

	public Integer getInt(String columnName) {
		return (Integer) get(new Column(columnName));
	}

	public Double getDouble(String columnName) {
		return (Double) get(new Column(columnName));
	}

	public Float getFloat(String columnName) {
		return (Float) get(new Column(columnName));
	}

	public BigDecimal getBigDecimal(String columnName) {
		return (BigDecimal) get(new Column(columnName));
	}

	public String getString(String columnName) {
		return (String) get(new Column(columnName));
	}

	public Date getDate(String columnName) {
		return (Date) get(new Column(columnName));
	}

}
