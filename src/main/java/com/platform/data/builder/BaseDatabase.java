package com.platform.data.builder;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.platform.data.ITable;
import com.platform.data.util.JdbcUtil;

public abstract class BaseDatabase implements IDatabase {

	/** 数据源 */
	private DataSource dataSource;

	public BaseDatabase(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<String> getAllTableName() throws SQLException {
		return JdbcUtil.getAllTableName(dataSource);
	}

	@Override
	public List<ITable> getAllTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITable getTable(String tableName) {
		return null;
	}

	@Override
	public void createTable(ITableBuilder tableBuilder) throws SQLException{
		JdbcUtil.executeUpdate(dataSource, tableBuilder);
	}

	@Override
	public void dropTable(String tableName) throws SQLException{
		JdbcUtil.executeUpdate(dataSource, "drop table " + tableName);
	}

}
