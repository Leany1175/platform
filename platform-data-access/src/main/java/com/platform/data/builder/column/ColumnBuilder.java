package com.platform.data.builder.column;

import com.platform.data.model.ColumnMeta;

public class ColumnBuilder {
    
    private ColumnMeta columnMeta;

    public ColumnBuilder() {
        columnMeta = new ColumnMeta();
    }

    public ColumnBuilder(ColumnMeta columnMeta) {
        this.columnMeta = columnMeta;
    }

    /**
     * 保存列名
     * @param columnName 列名
     * @return this
     */
    public ColumnBuilder columnName(String columnName) {
        columnMeta.setColumnName(columnName);
        return this;
    }

    /**
     * 列类型
     * @param columnType 列类型 java.sql.Types
     * @return this
     */
    public ColumnBuilder columnType(int columnType) {
        columnMeta.setColumnType(columnType);
        return this;
    }

    /**
     * 长度
     * @param length 长度
     * @return this
     */
    public ColumnBuilder length (int length) {
        columnMeta.setLength(length);
        return this;
    }

    /**
     * 列精度
     * @param precision 精度
     * @return this
     */
    public ColumnBuilder precision(int precision) {
        columnMeta.setPrecision(precision);
        return this;
    }

    /**
     * 默认值
     * @param defaultValue 默认值
     * @return this
     */
    public ColumnBuilder defaultValue(Object defaultValue) {
        columnMeta.setDefaultValue(defaultValue);
        return this;
    }

    /**
     * 允许为null
     * @param isNull 默认true,允许为null
     * @return this
     */
    public ColumnBuilder isNull(boolean isNull) {
        columnMeta.setNull(isNull);
        return this;
    }

    public ColumnMeta build() {
        return columnMeta;
    }
}
