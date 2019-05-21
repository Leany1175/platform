package com.platform.data.enums;

public enum ColumnTypeEnum {

    CHAR, // 字符
    TEXT, // 字符串
    INTEGER, // 整型
    FLOAT, // 浮点
    DOUBLE, // 双精度浮点
    DECIMAL, // 数字
    DATE, // 时间
    TIMESTAMP // 时间戳
    ;

    /**
     * 小写
     * @return 小写
     */
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
