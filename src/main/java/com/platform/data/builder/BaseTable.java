package com.platform.data.builder;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import com.platform.data.Column;
import com.platform.data.DataSet;
import com.platform.data.ITable;
import com.platform.data.Row;
import com.platform.data.util.JdbcUtil;

public abstract class BaseTable implements ITable {

	/** 表名 */
	protected String name;

	/** 数据源 */
	protected DataSource dataSource;

	public BaseTable(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public BaseTable(DataSource dataSource, String name) {
		this.dataSource = dataSource;
		this.name = name;
	}

	@Override
	public String getTableName() {
		return name;
	}

	@Override
	public void addColumn(IColumnBuilder columnBuilder) throws SQLException {
		JdbcUtil.executeUpdate(dataSource, "alter table " + name + " add column " + columnBuilder.build());
	}

	@Override
	public void modifyColumn(IColumnBuilder columnBuilder) throws SQLException {
		JdbcUtil.executeUpdate(dataSource, "alter table " + name + " modify " + columnBuilder.build());
	}

	@Override
	public void modifyColumn(String oldColumn, IColumnBuilder columnBuilder) throws SQLException{
		JdbcUtil.executeUpdate(dataSource, "alter table " + name + " change " + oldColumn + " " + columnBuilder.build());
	}

	@Override
	public void deleteColumn(String columnName) throws SQLException{
		JdbcUtil.executeUpdate(dataSource, "alter table " + name + " drop column " + columnName);
	}

	@Override
	public int columnCount() throws SQLException{
		return JdbcUtil.columnCount(dataSource, name);
	}

	@Override
	public List<Column> columnList() throws SQLException{
		return JdbcUtil.columnList(dataSource, name);
	}

	@Override
	public Iterator<Column> columnIterator() throws SQLException{
		return columnList().iterator();
	}

	@Override
	public List<DataSet> executeQuery(QueryBuilder queryBuilder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataSet> executeQuery(QueryBuilder... queryBuilders) {
		return null;
	}

	@Override
	public List<DataSet> executeQuery(List<QueryBuilder> queryBuilders) {
		return null;
	}

	@Override
	public int executeUpdate(Row row) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(Row... rows) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(List<Row> rows) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRow(Row row) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRow(Row... row) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRow(List<Row> row) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setName(String name) {
		this.name = name;
	}
}
