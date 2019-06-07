package com.platform.data.mysql;

import com.platform.data.IDatabase;
import com.platform.data.IDatabaseFactory;

import javax.sql.DataSource;

public class MysqlDatabaseFactory implements IDatabaseFactory {

    @Override
    public IDatabase openDatabase(DataSource dataSource) {
        return new MysqlDatabase(dataSource);
    }

}
