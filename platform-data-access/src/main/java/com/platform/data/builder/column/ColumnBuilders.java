package com.platform.data.builder.column;

import com.platform.data.enums.ColumnTypeEnum;
import com.platform.data.entity.ColumnConstruction;

public class ColumnBuilders {

    private ColumnConstruction column = new ColumnConstruction();

    public ColumnBuilders() {}

    public ColumnBuilders(ColumnConstruction column) {
        this.column = column;
    }

    /**
     * 保存列名
     * @param columnName 列名
     * @return this
     */
    public ColumnBuilders columnName(String columnName) {
        column.setColumnName(columnName);
        return this;
    }

    /**
     * 列类型
     * @param columnTypeEnum 列类型
     * @return this
     */
    public ColumnBuilders columnType(ColumnTypeEnum columnTypeEnum) {
        column.setColumnTypeEnum(columnTypeEnum);
        return this;
    }

    /**
     * 长度
     * @param length 长度
     * @return this
     */
    public ColumnBuilders length (int length) {
        column.setLength(length);
        return this;
    }

    /**
     * 列精度
     * @param precision 精度
     * @return this
     */
    public ColumnBuilders precision(int precision) {
        column.setPrecision(precision);
        return this;
    }

    /**
     * 默认值
     * @param defaultValue 默认值
     * @return this
     */
    public ColumnBuilders defaultValue(Object defaultValue) {
        column.setDefaultValue(defaultValue);
        return this;
    }

    /**
     * 允许为null
     * @param isNull 默认true,允许为null
     * @return this
     */
    public ColumnBuilders isNull(boolean isNull) {
        column.setNull(isNull);
        return this;
    }

    /**
     * 构建
     * @return 列信息
     */
    public ColumnConstruction build() {
        return column;
    }

    /**
     * 构建sql语句
     * @param columnBuilder 列建造者
     * @return sql语句
     */
    public String build(IColumnBuilder columnBuilder) {
        return columnBuilder.build(column);
    }

}
