package com.platform.data.oracle;

import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.entity.ColumnConstruction;
import com.platform.data.builder.table.BaseTableBuilder;

public class OracleTableBuilder extends BaseTableBuilder {

    @Override
    protected String buildColumn(ColumnConstruction column) {
        return new ColumnBuilders(column).build(new OracleColumnBuilder());
    }

}
