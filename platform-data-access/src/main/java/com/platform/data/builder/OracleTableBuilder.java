package com.platform.data.builder;

import com.platform.data.entity.ColumnConstruction;

public class OracleTableBuilder extends BaseTableBuilder {

    @Override
    protected String createVarcharColumn(ColumnConstruction column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" varchar2")
                .append("(")
                .append(column.getLength())
                .append(")");

        defaultAndNull(buffer, column);
        return buffer.toString();
    }

    /**
     * oracle里面没有double类型,设置为float
     * @param column 列
     * @return sql
     */
    @Override
    protected String createDoubleColumn(ColumnConstruction column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" float");

        defaultAndNull(buffer, column);
        return buffer.toString();
    }

}
