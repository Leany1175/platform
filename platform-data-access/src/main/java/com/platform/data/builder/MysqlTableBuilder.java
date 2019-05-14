package com.platform.data.builder;

import com.platform.data.entity.ColumnConstruction;

public class MysqlTableBuilder extends BaseTableBuilder {

    @Override
    protected String createIntegerColumn(ColumnConstruction column) {
        return createColumnLength(column);
    }

    @Override
    protected String createTimestampColumn(ColumnConstruction column) {
        StringBuffer buffer = new StringBuffer(column.getColumnName())
                .append(" datetime");
        defaultAndNull(buffer, column);
        return buffer.toString();
    }

}
