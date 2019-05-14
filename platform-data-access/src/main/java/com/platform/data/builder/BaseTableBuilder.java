package com.platform.data.builder;

import com.platform.data.entity.ColumnConstruction;
import com.platform.data.entity.TableConstruction;
import com.platform.data.enums.ColumnTypeEnum;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTableBuilder implements ITableBuilder {

    @Override
    public String build(TableConstruction construction, boolean format) {
        StringBuffer buffer = new StringBuffer("create table ")
                .append(construction.getTableName())
                .append(" (?)");
        // sql语句
        String sql = buffer.toString();
        // 列 sql集合
        List<String> columnList = createColumn(construction.getColumnList());
        if (format) {
            return sql.replaceAll("\\?", "\n\t\t" + String.join(",\n\t\t", columnList) + "\n");
        }
        return sql.replaceAll("\\?", String.join(",", columnList));
    }

    /**
     * 列sql集合
     * @param columnList 列信息
     * @return sql
     */
    protected List<String> createColumn(List<ColumnConstruction> columnList) {
        List<String> list = new ArrayList<>(columnList.size());
        for (ColumnConstruction column : columnList) {
            if (column.getColumnTypeEnum() == ColumnTypeEnum.CHAR) { // 字符
                list.add(createCharColumn(column));
            } else if (column.getColumnTypeEnum() == ColumnTypeEnum.STRING) { // 字符串
                list.add(createVarcharColumn(column));
            } else if (column.getColumnTypeEnum() == ColumnTypeEnum.TEXT) { // 大文本
                list.add(createTextColumn(column));
            } else if (column.getColumnTypeEnum() == ColumnTypeEnum.INTEGER) { // 整型
                list.add(createIntegerColumn(column));
            } else if (column.getColumnTypeEnum() == ColumnTypeEnum.FLOAT) { // 单精度浮点
                list.add(createFloatColumn(column));
            } else if (column.getColumnTypeEnum() == ColumnTypeEnum.DOUBLE) { // 单精度浮点
                list.add(createDoubleColumn(column));
            } else if (column.getColumnTypeEnum() == ColumnTypeEnum.DECIMAL) { //decimal 列类型
                list.add(createDecimalColumn(column));
            } else if (column.getColumnTypeEnum() == ColumnTypeEnum.DATE) { // 时间
                list.add(createDateColumn(column));
            } else if (column.getColumnTypeEnum() == ColumnTypeEnum.TIMESTAMP) { // 时间戳
                list.add(createTimestampColumn(column));
            }
        }
        return list;
    }

    /**
     * 字符
     * @param column 列
     * @return sql
     */
    protected String createCharColumn(ColumnConstruction column) {
        return createColumnLength(column);
    }

    /**
     * 字符串列
     * @param column 列信息
     * @return sql
     */
    protected String createVarcharColumn(ColumnConstruction column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" varchar")
                .append("(")
                .append(column.getLength())
                .append(")");

        defaultAndNull(buffer, column);
        return buffer.toString();
    }

    /**
     * 大文本
     * @param column 列信息
     * @return sql
     */
    protected String createTextColumn(ColumnConstruction column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" blob");

        defaultAndNull(buffer, column);
        return buffer.toString();
    }

    /**
     * 整型
     * @param column 列
     * @return sql
     */
    protected String createIntegerColumn(ColumnConstruction column) {
        return createColumn(column);
    }

    /**
     * 单精度浮点
     * @param column 列
     * @return sql
     */
    protected String createFloatColumn(ColumnConstruction column) {
        return createColumn(column);
    }

    /**
     * 双精度浮点
     * @param column 列
     * @return sql
     */
    protected String createDoubleColumn(ColumnConstruction column) {
        return createColumn(column);
    }

    /**
     * 时间
     * @param column 列
     * @return sql
     */
    protected String createDateColumn(ColumnConstruction column) {
        return createColumn(column);
    }

    /**
     * 时间戳
     * @param column 列
     * @return sql
     */
    protected String createTimestampColumn(ColumnConstruction column) {
        return createColumn(column);
    }


    /**
     * 生成列SQL
     * @param column 列信息
     * @return 列SQL
     */
    protected String createDecimalColumn(ColumnConstruction column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" ")
                .append(column.getColumnTypeEnum())
                .append("(")
                .append(column.getLength())
                .append(", ")
                .append(column.getPrecision())
                .append(")");

        defaultAndNull(buffer, column);
        return buffer.toString();
    }

    /**
     * 填充默认值和是否允许为null
     * @param buffer sql语句
     * @param column 列信息
     */
    protected void defaultAndNull(StringBuffer buffer, ColumnConstruction column) {
        // 默认值
        if (column.getDefaultValue() != null) {
            buffer.append(" default ");
            Object value = column.getDefaultValue();
            if (value instanceof Number) {
                buffer.append(value);
            } else {
                buffer.append("'").append(value).append("'");
            }
        }
        // 允许为空
        if (!column.isNull()) {
            buffer.append(" not null");
        }
    }

    /**
     * 生成默认列的sql语句,不带长度
     * @param column 列信息
     * @return sql
     */
    protected String createColumn(ColumnConstruction column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" ")
                .append(column.getColumnTypeEnum());

        defaultAndNull(buffer, column);
        return buffer.toString();
    }

    /**
     * 生成默认列的sql语句,带长度
     * @param column 列信息
     * @return sql
     */
    protected String createColumnLength(ColumnConstruction column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" ")
                .append(column.getColumnTypeEnum());

        if (column.getLength() > 0) {
            buffer.append("(").append(column.getLength()).append(")");
        }
        defaultAndNull(buffer, column);
        return buffer.toString();
    }


}
