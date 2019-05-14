package com.platform.data.builder;

import com.platform.data.entity.ColumnConstruction;

public class OracleTableBuilder extends BaseTableBuilder {

    @Override
    protected String buildColumn(ColumnConstruction column) {
        return new ColumnBuilders(column).build(new OracleColumnBuilder());
    }

}
