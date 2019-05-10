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
    /** 是否是主键 */
    private boolean isPK = false;
    /** 是否是自增 */
    private boolean isAuto = false;
    /** 允许为空 */
    private boolean isNull = true;

}
