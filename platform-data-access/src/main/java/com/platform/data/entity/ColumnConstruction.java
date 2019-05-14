package com.platform.data.entity;

import com.platform.data.enums.ColumnTypeEnum;

import java.io.Serializable;

public class ColumnConstruction implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 列名 */
    private String columnName;
    /** 列类型 */
    private ColumnTypeEnum columnTypeEnum;
    /** 列长度 */
    private int length;
    /** 列精度,针对decimal */
    private int precision;
    /** 默认值 */
    private Object defaultValue;
    /** 允许为null */
    private boolean isNull = true;

    public String getColumnName() {
        return columnName;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ColumnTypeEnum getColumnTypeEnum() {
        return columnTypeEnum;
    }

    public void setColumnTypeEnum(ColumnTypeEnum columnTypeEnum) {
        this.columnTypeEnum = columnTypeEnum;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }
}
