package com.platform.data.oracle;

import com.platform.data.builder.table.BaseTableBuilder;

public class OracleTableBuilder extends BaseTableBuilder {

    public OracleTableBuilder() {
        this.columnBuilder = new OracleColumnBuilder();
    }

}
