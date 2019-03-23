package com.platform.data.builder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.platform.data.IDatabase;
import com.platform.data.ITable;
import com.platform.data.util.JdbcUtil;

public abstract class BaseDatabase implements IDatabase {

	/** 数据源 */
	protected DataSource dataSource;

	public BaseDatabase(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean existsTable(String tableName) throws SQLException {
		return getAllTableName().contains(tableName);
	}

	@Override
	public List<String> getAllTableName() throws SQLException {
		return JdbcUtil.getAllTableName(dataSource);
	}

	@Override
	public List<ITable> getAllTable() throws SQLException{
		List<String> nameList = getAllTableName();
		List<ITable> tableList = new ArrayList<>(nameList.size());
		for (String name : nameList) {
			tableList.add(getTable(name));
		}
		return tableList;
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
