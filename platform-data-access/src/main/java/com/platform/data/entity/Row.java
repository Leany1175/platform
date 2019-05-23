package com.platform.data.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 行:key=列名,value=值
 */
public class Row extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	/**
	 * 追加
	 * @param key 列名
	 * @param value 值
	 * @return
	 */
	public Row add(String key, Object value) {
		put(key, value);
		return this;
	}

	/**
	 * 返回所有key
	 * @param split 分隔符
	 * @return name分隔符sex分隔符age
	 */
	public String keyAsString(String split) {
		List<String> keyList = new ArrayList<>(size());
		this.forEach((key, value) -> keyList.add(key));
		return String.join(split, keyList);
	}

	/**
	 * 返回所有key
	 * @return name, sex, age
	 */
	public String keyAsString() {
		List<String> keyList = new ArrayList<>(size());
		this.forEach((key, value) -> keyList.add(key));
		return String.join(", ", keyList);
	}

	public String getString(String key) {
		return (String) get(key);
	}

	public Number getNumber(String key) {
		return (Number) get(key);
	}

	public Integer getInteger(String key) {
		return (Integer) get(key);
	}

	public Long getLong(String key) {
		return (Long) get(key);
	}

	public Double getDouble(String key) {
		return (Double) get(key);
	}

	public Float getFloat(String key) {
		return (Float) get(key);
	}

	public Date getDate(String key) {
		return (Date) get(key);
	}

	public Timestamp getTimestamp(String key) {
		return (Timestamp) get(key);
	}

}
