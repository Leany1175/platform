package com.platform.data.mysql;

import com.platform.data.builder.table.BaseTableBuilder;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.entity.ColumnConstruction;

public class MysqlTableBuilder extends BaseTableBuilder {

    @Override
    protected String buildColumn(ColumnConstruction column) {
        return new ColumnBuilders(column).build(new MysqlColumnBuilder());
    }

}
