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
//        System.out.println(String.join(",", columnList));
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
            if (column.getColumnTypeEnum() == ColumnTypeEnum.DECIMAL) { //decimal 列类型
                list.add(createDecimalColumn(column));
            } else if (column.getColumnTypeEnum() == ColumnTypeEnum.STRING) { // 字符串
                list.add(createVarcharColumn(column));
            } else  { // 其他
                list.add(createDefaultColumn(column));
            }
        }
        return list;
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
     * 生成默认列的sql语句
     * @param column 列信息
     * @return sql
     */
    protected String createDefaultColumn(ColumnConstruction column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" ")
                .append(column.getColumnTypeEnum());

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

}
