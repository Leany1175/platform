package com.platform.data.mysql;

import com.platform.data.builder.column.BaseColumnBuilder;
import com.platform.data.entity.ColumnConstruction;
import com.platform.data.model.ColumnMeta;

public class MysqlColumnBuilder extends BaseColumnBuilder {

    @Override
    protected String createLongVarcharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumnLength(columnMeta), "varchar");
    }

    @Override
    protected String createLongVarbinaryColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumnLength(columnMeta), "varbinary");
    }
    @Override
    protected String createTimestampColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "datetime");
    }

    protected String createNullColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    protected String createOtherColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    protected String createJavaObjectColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    protected String createDistinctColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    protected String createStructColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createArrayColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createClobColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createRefColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createDatalinkColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createRowidColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createLongNVarcharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumnLength(columnMeta), "nvarchar");
    }

    @Override
    protected String createNClobColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createSQLXMLColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createRefCursorColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createTimeWithTimezoneColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "time");
    }

    @Override
    protected String createTimestampWithTimezoneColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "datetime");
    }

}
