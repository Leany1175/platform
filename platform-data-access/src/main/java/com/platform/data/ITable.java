package com.platform.data;

//import com.platform.data.builder.IAggregationBuilder;
//import com.platform.data.builder.IColumnBuilder;
//import com.platform.data.entity.Column;
//import com.platform.data.entity.Row;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface ITable {

//	/**
//	 * 获取表名
//	 */
//	String getTableName();
//
//	/**
//	 * 添加列
//	 * @param columnBuilder 列
//	 * @exception SQLException 异常
//	 */
//	void addColumn(IColumnBuilder columnBuilder) throws SQLException;
//
//	/**
//	 * 更改列
//	 * @param columnBuilder 列
//	 * @exception SQLException 异常
//	 */
//	void modifyColumn(IColumnBuilder columnBuilder) throws SQLException;
//
//	/**
//	 * 更改列
//	 * @param oldColumn 需要修改的列名
//	 * @param columnBuilder 列
//	 * @exception SQLException 异常
//	 */
//	void modifyColumn(String oldColumn, IColumnBuilder columnBuilder) throws SQLException;
//
//	/**
//	 * 删除列
//	 * @param columnName 列名
//	 * @exception SQLException 异常
//	 */
//	void deleteColumn(String columnName) throws SQLException;
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

//	/**
//	 * 查询
//	 * @param queryBuilder 查询条件
//	 * @return 查询结果
//	 * @exception SQLException 异常
//	 */
//	ISearchResult query(IQueryBuilder queryBuilder) throws SQLException;

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
//	/**
//	 * 添加或更新
//	 * @param row 行
//	 * @return 受影响行数
//	 * @exception SQLException 异常
//	 */
//	int executeUpdate(Row row) throws SQLException;
//
//	/**
//	 * 批量添加或更新
//	 * @param rows 行
//	 * @return 收影响行数
//	 */
//	int executeUpdate(Collection<Row> rows);
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
