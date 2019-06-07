package com.platform.data.oracle;

import com.platform.data.IDatabase;
import com.platform.data.IDatabaseFactory;

import javax.sql.DataSource;

public class OracleDatabaseFactory implements IDatabaseFactory {

    @Override
    public IDatabase openDatabase(DataSource dataSource) {
        return new OracleDatabase(dataSource);
    }

}
