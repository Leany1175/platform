package com.platform.data.entity;

import java.io.Serializable;

public class Column implements Serializable {

    /** 列名 */
    private String columnName;
    /** 列类型名 */
    private String columnType;
    /** 列对应的类名 */
    private String columnClassName;
    /** 长度 */
    private int length;
    /** 精度 */
    private int precision;
    /** 默认值 */
    private Object defaultValue;
//    /** 是否是主键 */
//    private boolean isPK = false;
    /** 是否是自增 */
    private boolean isAuto = false;
    /** 允许为空 */
    private boolean isNull = true;

    public Column() {
    }

    public Column(String columnName, String columnType) {
        this.columnName = columnName;
        this.columnType = columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnClassName() {
        return columnClassName;
    }

    public void setColumnClassName(String columnClassName) {
        this.columnClassName = columnClassName;
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

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

//    public boolean isPK() {
//        return isPK;
//    }
//
//    public void setPK(boolean PK) {
//        isPK = PK;
//    }

    public boolean isAuto() {
        return isAuto;
    }

    public void setAuto(boolean auto) {
        isAuto = auto;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

}
