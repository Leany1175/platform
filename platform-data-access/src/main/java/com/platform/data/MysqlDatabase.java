package com.platform.data;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.platform.data.entity.Table;

public class MysqlDatabase extends BaseDatabase {

    public MysqlDatabase(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void createTable(Table tableBuilder) throws SQLException {
        super.createTable(tableBuilder);
    }
}
