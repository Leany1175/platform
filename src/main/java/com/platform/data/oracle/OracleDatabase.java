package com.platform.data.oracle;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.platform.data.ITable;
import com.platform.data.base.BaseDatabase;

public class OracleDatabase extends BaseDatabase {

	public OracleDatabase(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public ITable getTable(String tableName) throws SQLException {
		return null;
	}

}
