package com.platform.data.base;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.platform.data.IAggregationResult;
import com.platform.data.IDatabase;
import com.platform.data.ISearchResult;
import com.platform.data.builder.IAggregationBuilder;
import com.platform.data.builder.IQueryBuilder;
import com.platform.data.builder.ITableBuilder;
import com.platform.data.entity.ExportOption;
import com.platform.data.util.JdbcUtil;

public abstract class BaseDatabase implements IDatabase {

	/** 数据源 */
	protected DataSource dataSource;

	public BaseDatabase(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<String> getAllTableName() throws SQLException {
		return JdbcUtil.getAllTableName(dataSource);
	}

	@Override
	public void createTable(ITableBuilder tableBuilder) throws SQLException{
		JdbcUtil.executeUpdate(dataSource, tableBuilder);
	}

	@Override
	public void dropTable(String tableName) throws SQLException{
		JdbcUtil.executeUpdate(dataSource, "drop table " + tableName);
	}

	@Override
	public ISearchResult query(IQueryBuilder queryBuilder) throws SQLException {
		return null;
	}

	@Override
	public IAggregationResult aggregation(IAggregationBuilder aggregationBuilder) {
		return null;
	}

	@Override
	public File export(ExportOption option, String... tableName) {
		return null;
	}

	@Override
	public void importFile(File file) {

	}

	@Override
	public void importSql(File file) {

	}
}
