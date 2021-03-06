package com.platform.data;

import com.platform.data.builder.column.ColumnBuilder;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.entity.Row;
import com.platform.data.query.ISearchResult;
import com.platform.data.query.QueryBuilder;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface ITable {

	String getTableName();

	/**
	 * add column
	 * @param columnBuilder
	 * @throws SQLException
	 */
	void addColumn(ColumnBuilder columnBuilder) throws SQLException;

	/**
	 * modify column, do not include column name
	 * @param columnBuilder column
	 * @exception SQLException
	 */
	void modifyColumn(ColumnBuilder columnBuilder) throws SQLException;

	/**
	 * rename column
	 * @param columnName old_column_name
	 * @param columnBuilder column info
	 * @exception SQLException
	 */
	void renameColumn(String columnName, ColumnBuilder columnBuilder) throws SQLException;

	/**
	 * 删除列
	 * @param columnName 列名
	 * @exception SQLException 异常
	 */
	void dropColumn(String columnName) throws SQLException;
//
//	/**
//	 * 列数
//	 * @return 几列
//	 * @exception SQLException 异常
//	 */
//	int columnCount() throws SQLException;
//
//	/**
//	 * 获取列集合
//	 * @return 列集合
//	 * @exception SQLException 异常
//	 */
//	List<Column> columnList() throws SQLException;

	/**
	 * 查询
	 * @param queryBuilder 查询条件
	 * @return 查询结果
	 * @exception SQLException 异常
	 */
	ISearchResult query(QueryBuilder queryBuilder) throws SQLException;

//	/**
//	 * 查询所有
//	 * @param queryBuilder 查询条件
//	 * @return 行集合
//	 * @exception SQLException 异常
//	 */
//	List<Row> queryAll(IQueryBuilder queryBuilder) throws SQLException;

//	/**
//	 * TODO 聚合
//	 * @param aggregationBuilder 条件
//	 */
//	IAggregationResult aggregation(IAggregationBuilder aggregationBuilder);

//	/**
//	 * 表查询
//	 * @param whereClause 过滤,排序条件
//	 * @return 查询结果
//	 */
//	ISearchResult query(IWhereClause whereClause);
//
//	/**
//	 * 聚合
//	 * @param aggregationBuilder 聚合
//	 * @param whereClause 条件
//	 * @return 聚合结果
//	 */
//	IAggregationResult aggregation(IAggregationBuilder aggregationBuilder, IWhereClause whereClause);
//
	/**
	 * insert
	 * @param row
	 * @return
	 * @exception SQLException
	 */
	int insert(Row row) throws SQLException;

	/**
	 * 批量添加或更新, 要求每一行 key相等,并且key个数相等
	 * @param rows 行
	 * @return 收影响行数
	 * @exception SQLException 失败
	 */
	int[] insert(List<Row> rows) throws SQLException;

	/**
	 * 修改所有的行
	 * @param row 行
	 * @return 行数
	 * @exception SQLException 异常
	 */
	int update(Row row) throws SQLException;

	/**
	 * 根据查询修改
	 * @param row 行
	 * @param queryBuilder 查询条件
	 */
	int update(Row row, QueryBuilder queryBuilder);

	/**
	 * 删除所有数据
	 * @return 删除条数
	 */
	int delete();

	/**
	 * 根绝查询删除
	 * @param queryBuilder 查询条件
	 * @return 删除条数
	 */
	int delete(QueryBuilder queryBuilder);

//
//	/**
//	 * 删除
//	 * @param row 行
//	 * @return 收影响行数
//	 */
//	int deleteRow(Row row);
//
//	/**
//	 * 批量删除
//	 * @param row 行
//	 * @return 收影响行数
//	 */
//	int deleteRow(Collection<Row> row);


}
