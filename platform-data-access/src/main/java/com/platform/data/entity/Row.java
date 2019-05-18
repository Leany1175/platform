package com.platform.data.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

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
