package com.platform.data.db;

import com.platform.data.builder.ColumnBuilders;
import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.OracleColumnBuilder;

import javax.sql.DataSource;

public class OracleTable extends BaseTable{

    public OracleTable(DataSource dataSource, String tableName) {
        super(dataSource, tableName);
    }

    @Override
    protected IColumnBuilder createBuilder() {
        return new OracleColumnBuilder();
    }

    @Override
    public boolean addColumn(ColumnBuilders columnBuilder) {
        // TODO oracle添加列
        return super.addColumn(columnBuilder);
    }

    //    @Override
//    public boolean addColumn(ColumnBuilders columnBuilder) {
//        return false;
//    }
}
