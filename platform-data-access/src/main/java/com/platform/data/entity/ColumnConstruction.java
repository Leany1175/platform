package com.platform.data.entity;

import com.platform.data.enums.ColumnTypeEnum;

import java.io.Serializable;
import java.math.BigDecimal;

public class ColumnConstruction implements Serializable {

    /** 列名 */
    private String columnName;
    /** 列类型 */
    private ColumnTypeEnum columnTypeEnum;
    /** 列长度 */
    private int length;
    /** 列精度,针对decimal */
    private int precision;
    /** 允许为null */
    private boolean isNull = true;

    public String getColumnName() {
        return columnName;
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
