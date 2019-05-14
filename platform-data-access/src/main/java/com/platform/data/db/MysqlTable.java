package com.platform.data.db;

import com.platform.data.builder.ColumnBuilders;
import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.MysqlColumnBuilder;

import javax.sql.DataSource;

public class MysqlTable extends BaseTable{

    public MysqlTable(DataSource dataSource, String tableName) {
        super(dataSource, tableName);
    }

    @Override
    protected IColumnBuilder createBuilder() {
        return new MysqlColumnBuilder();
    }

//    @Override
//    public boolean addColumn(ColumnBuilders columnBuilder) {
//        StringBuffer buffer = new StringBuffer("alter table ")
//                .append(TABLE_NAME)
//                .append("add column ")
//                .append(columnBuilder.build(null));
//
//        columnBuilder.build(new MysqlColumnBuilder());
//        return false;
//    }



}
