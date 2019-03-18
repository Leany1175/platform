package com.platform.data;

import com.platform.data.builder.QueryBuilder;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class SimpleDataSet implements DataSet {

	/** 数据源 */
	private DataSource dataSource;
	/** 查询条件 */
	private QueryBuilder queryBuilder;

	/**
	 * 对象构造的是够查询数据库
	 * @param dataSource 数据源
	 * @param queryBuilder 查询条件
	 * @throws SQLException 查询异常
	 */
	public SimpleDataSet(DataSource dataSource, QueryBuilder queryBuilder) throws SQLException {
		this.dataSource = dataSource;
		this.queryBuilder = queryBuilder;
	}

	@Override
	public int totalColumn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Column> columnList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Column> columIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalRow() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Row> rowList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Row> rowIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
