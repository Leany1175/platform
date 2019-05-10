package com.platform.data;

import javax.sql.DataSource;

public class MysqlDatabase extends BaseDatabase {

    public MysqlDatabase(DataSource dataSource) {
        super(dataSource);
    }
}
