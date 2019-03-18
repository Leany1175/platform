package com.platform.data;

import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.QueryBuilder;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public interface ITable {

	/**
	 * 获取表名
	 */
	String getTableName();

	/**
	 * 添加列
	 * @param columnBuilder 列
	 * @exception SQLException 异常
	 */
	void addColumn(IColumnBuilder columnBuilder) throws SQLException;

	/**
	 * 更改列
	 * @param columnBuilder 列
	 * @exception SQLException 异常
	 */
	void modifyColumn(IColumnBuilder columnBuilder) throws SQLException;

	/**
	 * 更改列
	 * @param oldColumn 需要修改的列名
	 * @param columnBuilder 列
	 * @exception SQLException 异常
	 */
	void modifyColumn(String oldColumn, IColumnBuilder columnBuilder) throws SQLException;

	/**
	 * 删除列
	 * @param columnName 列名
	 * @exception SQLException 异常
	 */
	void deleteColumn(String columnName) throws SQLException;

	/**
	 * 列数
	 * @return 几列
	 * @exception SQLException 异常
	 */
	int columnCount() throws SQLException;

	/**
	 * 获取列集合
	 * @return 列集合
	 * @exception SQLException 异常
	 */
	List<Column> columnList() throws SQLException;

	/**
	 * 返回一个迭代器
	 * @return 迭代器
	 * @exception SQLException 异常
	 */
	Iterator<Column> columnIterator() throws SQLException;

	/**
	 * 查询
	 * @param queryBuilder 查询条件
	 * @return 查询结果
	 */
	DataSet executeQuery(QueryBuilder queryBuilder);

	/**
	 * 添加或更新
	 * @param row 行
	 * @return 受影响行数
	 */
	int executeUpdate(Row row);

	/**
	 * 批量添加或更新
	 * @param rows 行
	 * @return 收影响行数
	 */
	int executeUpdate(Row... rows);

	/**
	 * 批量添加或更新
	 * @param rows 行
	 * @return 收影响行数
	 */
	int executeUpdate(List<Row> rows);

	/**
	 * 删除
	 * @param row 行
	 * @return 收影响行数
	 */
	int deleteRow(Row row);

	/**
	 * 批量删除
	 * @param row 行
	 * @return 收影响行数
	 */
	int deleteRow(Row... row);

	/**
	 * 批量删除
	 * @param row 行
	 * @return 收影响行数
	 */
	int deleteRow(List<Row> row);

}
