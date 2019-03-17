package com.platform.data.mysql;

import com.platform.data.ITable;
import com.platform.data.builder.BaseDatabase;

import javax.sql.DataSource;
import java.sql.SQLException;

public class MysqlDatabase extends BaseDatabase {

	public MysqlDatabase(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public ITable getTable(String tableName) throws SQLException {
		return new MysqlTable(dataSource, tableName);
	}

}
