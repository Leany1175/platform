package com.platform.data.entity;

import java.io.Serializable;

/**
 * 条件
 */
public class ConditionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public final static String TYPE_EQUALS = "TYPE_EQUALS";
    public final static String TYPE_NOT_EQUALS = "TYPE_NOT_EQUALS";
    public final static String TYPE_START_WITH = "TYPE_START_WITH";
    public final static String TYPE_LIKE = "TYPE_LIKE";
    public final static String TYPE_BETWEEN = "TYPE_BETWEEN";
    public final static String TYPE_GT = "TYPE_GT";
    public final static String TYPE_GTE = "TYPE_GTE";
    public final static String TYPE_LT = "TYPE_LT";
    public final static String TYPE_LTE = "TYPE_LTE";
    public final static String TYPE_IS_NULL = "TYPE_IS_NULL";
    public final static String TYPE_IS_NOT_NULL = "TYPE_IS_NOT_NULL";
    public final static String TYPE_IN = "TYPE_IN";
    public final static String TYPE_ASC = "TYPE_ASC";
    public final static String TYPE_DESC = "TYPE_DESC";

    /** 字段名 */
    private String key;
    /** 查询类型 */
    private String type;
    /** 值1 */
    private Object value1;
    /** 值2 */
    private Object value2;

    public ConditionBean() {
    }

    public ConditionBean(String key) {
        this.key = key;
    }

    public ConditionBean(String key, String type) {
        this.key = key;
        this.type = type;
    }

    public ConditionBean(String key, String type, Object value1) {
        this.key = key;
        this.type = type;
        this.value1 = value1;
    }

    public ConditionBean(String key, String type, Object value1, Object value2) {
        this.key = key;
        this.type = type;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue1() {
        return value1;
    }

    public void setValue1(Object value1) {
        this.value1 = value1;
    }

    public Object getValue2() {
        return value2;
    }

    public void setValue2(Object value2) {
        this.value2 = value2;
    }
}
