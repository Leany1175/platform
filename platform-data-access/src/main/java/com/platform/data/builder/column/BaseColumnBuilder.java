package com.platform.data.builder.column;

import com.platform.data.entity.ColumnConstruction;
import com.platform.data.enums.ColumnTypeEnum;
import com.platform.data.model.ColumnMeta;

import java.sql.Types;

public abstract class BaseColumnBuilder implements IColumnBuilder {

    @Override
    public String build(ColumnMeta columnMeta) {
        switch (columnMeta.getColumnType()) {
            case Types.BIT:
                return createBitColumn(columnMeta);
            case Types.TINYINT:
                return createTinyIntColumn(columnMeta);
            case Types.SMALLINT:
                return createSmallIntColumn(columnMeta);
            case Types.INTEGER:
                return createIntegerColumn(columnMeta);
            case Types.BIGINT:
                return createBigIntColumn(columnMeta);
            case Types.FLOAT:
                return createFloatColumn(columnMeta);
            case Types.REAL:
                return createRealColumn(columnMeta);
            case Types.DOUBLE:
                return createDoubleColumn(columnMeta);
            case Types.NUMERIC:
                return createNumericColumn(columnMeta);
            case Types.DECIMAL:
                return createDecimalColumn(columnMeta);
            case Types.CHAR:
                return createCharColumn(columnMeta);
            case Types.VARCHAR:
                return createVarcharColumn(columnMeta);
            case Types.LONGVARCHAR:
                return createLongVarcharColumn(columnMeta);
            case Types.DATE:
                return createDateColumn(columnMeta);
            case Types.TIME:
                return createTimeColumn(columnMeta);
            case Types.TIMESTAMP:
                return createTimestampColumn(columnMeta);
            case Types.BINARY:
                return createBinaryColumn(columnMeta);
            case Types.VARBINARY:
                return createVarBinaryColumn(columnMeta);
            case Types.LONGVARBINARY:
                return createLongVarcharColumn(columnMeta);
            case Types.NULL:
                return createNullColumn(columnMeta);
            case Types.OTHER:
                return createOtherColumn(columnMeta);
            case Types.JAVA_OBJECT:
                return createJavaObjectColumn(columnMeta);
            case Types.DISTINCT:
                return createDistinctColumn(columnMeta);
            case Types.STRUCT:
                return createStructColumn(columnMeta);
            case Types.ARRAY:
                return createArrayColumn(columnMeta);
            case Types.BLOB:
                return createBlobColumn(columnMeta);
            case Types.CLOB:
                return createClobColumn(columnMeta);
            case Types.REF:
                return createRefColumn(columnMeta);
            case Types.DATALINK:
                return createDatalinkColumn(columnMeta);
            case Types.BOOLEAN:
                return createBooleanColumn(columnMeta);
            case Types.ROWID:
                return createRowidColumn(columnMeta);
            case Types.NCHAR:
                return createNcharColumn(columnMeta);
            case Types.NVARCHAR:
                return createNVarcharColumn(columnMeta);
            case Types.LONGNVARCHAR:
                return createLongNVarcharColumn(columnMeta);
            case Types.NCLOB:
                return createNClobColumn(columnMeta);
            case Types.SQLXML:
                return createSQLXMLColumn(columnMeta);
            case Types.REF_CURSOR:
                return createRefCursorColumn(columnMeta);
            case Types.TIME_WITH_TIMEZONE:
                return createTimeWithTimezoneColumn(columnMeta);
            case Types.TIMESTAMP_WITH_TIMEZONE:
                return createTimestampWithTimezoneColumn(columnMeta);
        }
        throw new NullPointerException("Unknown column type");
    }

    /**
     * default and is null
     * @param buffer sql
     * @param column column info
     */
    protected void defaultAndNull(StringBuffer buffer, ColumnMeta column) {
        // 默认值
        if (column.getDefaultValue() != null) {
            buffer.append(" default ");
            Object value = column.getDefaultValue();
            // TODO
            if (value instanceof Number) {
                buffer.append(value);
            } else {
                buffer.append("'").append(value).append("'");
            }
        }
        // is empty
        if (!column.isNull()) {
            buffer.append(" not null");
        }
    }

    /**
     * create default colun without length "?" --> columType
     * @param column colun info
     * @return sql
     */
    protected String createColumn(ColumnMeta column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" ?");

        defaultAndNull(buffer, column);
        return buffer.toString();
    }

    /**
     * create default colun with length "?" --> columType
     * @param column column info
     * @return sql
     */
    protected String createColumnLength(ColumnMeta column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" ?");

        if (column.getLength() > 0) {
            buffer.append("(").append(column.getLength()).append(")");
        }
        defaultAndNull(buffer, column);
        return buffer.toString();
    }

    /**
     * ? --> replaceBy
     * @param str sql
     * @param replaceBy column type
     * @return
     */
    protected String replaceWith(String str, String replaceBy) {
        return str.replaceAll("\\?", replaceBy);
    }

    protected String createBitColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "bit");
    }

    protected String createTinyIntColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "tinyint");
    }

    protected String createSmallIntColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "smallint");
    }

    protected String createIntegerColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "integer");
    }

    protected String createBigIntColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "bigint");
    }

    protected String createFloatColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "float");
    }

    protected String createRealColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "real");
    }

    protected String createDoubleColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "double");
    }

    protected String createNumericColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "numeric");
    }

    protected String createDecimalColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "decimal");
    }

    protected String createCharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "char");
    }

    protected String createVarcharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumnLength(columnMeta), "varchar");
    }

    protected String createLongVarcharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumnLength(columnMeta), "longvarchar");
    }

    protected String createDateColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "date");
    }

    protected String createTimeColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "time");
    }

    protected String createTimestampColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "timestamp");
    }

    protected String createBinaryColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "binary");
    }

    protected String createVarBinaryColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "varbinary");
    }

    protected String createLongVarbinaryColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "longvarbinary");
    }

    protected String createNullColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "null");
    }

    protected String createOtherColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "other");
    }

    protected String createJavaObjectColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "java_object");
    }

    protected String createDistinctColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "distinct");
    }

    protected String createStructColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "struct");
    }

    protected String createArrayColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "array");
    }

    protected String createBlobColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "blob");
    }

    protected String createClobColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "clob");
    }

    protected String createRefColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "Ref");
    }

    protected String createDatalinkColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "datalink");
    }

    protected String createBooleanColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "boolean");
    }

    protected String createRowidColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "rowid");
    }

    protected String createNcharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "nchar");
    }

    protected String createNVarcharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "nvarchar");
    }

    protected String createLongNVarcharColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "longnvarchar");
    }

    protected String createNClobColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "nclob");
    }

    protected String createSQLXMLColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "sqlxml");
    }

    protected String createRefCursorColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "ref_cursor");
    }

    protected String createTimeWithTimezoneColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "time_with_timezone");
    }

    protected String createTimestampWithTimezoneColumn(ColumnMeta columnMeta) {
        return replaceWith(createColumn(columnMeta), "timestamp_with_timezone");
    }

}
