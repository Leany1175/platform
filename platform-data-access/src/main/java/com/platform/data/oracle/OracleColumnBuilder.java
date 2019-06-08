package com.platform.data.oracle;

import com.platform.data.builder.column.BaseColumnBuilder;
import com.platform.data.entity.ColumnConstruction;
import com.platform.data.model.ColumnMeta;

public class OracleColumnBuilder extends BaseColumnBuilder {

    @Override
    protected String createBitColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "char");
    }

    @Override
    protected String createTinyIntColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "smallint");
    }

    @Override
    protected String createBigIntColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "long");
    }

    @Override
    protected String createDoubleColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "float");
    }

    @Override
    protected String createVarcharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumnLength(columnMeta), "varchar2");
    }

    @Override
    protected String createLongVarcharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumnLength(columnMeta), "varchar2");
    }

    @Override
    protected String createTimeColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "timestamp");
    }

    @Override
    protected String createBinaryColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    protected String createVarBinaryColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createLongVarbinaryColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createNullColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createOtherColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createJavaObjectColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createDistinctColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createStructColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createArrayColumn(ColumnMeta columnMeta) {
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
    protected String createBooleanColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "char");
    }

    @Override
    protected String createRowidColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createNVarcharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumnLength(columnMeta), "nvarchar2");
    }

    @Override
    protected String createLongNVarcharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumnLength(columnMeta), "nvarchar2");
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
        return replaceWith(createColumn(columnMeta), "blob");
    }

    @Override
    protected String createTimestampWithTimezoneColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

}
