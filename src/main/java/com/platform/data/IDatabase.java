package com.platform.data;

import com.platform.data.builder.ITableBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * 数据库
 */
public interface IDatabase {

	/**
	 * 表名是否存在
	 * @param tableName 表名
	 * @return true:表示改表存在
	 * @throws SQLException 异常
	 */
	boolean existsTable(String tableName) throws SQLException;

	/**
	 * 返回所有表名
	 * @return 表名
	 * @exception SQLException 数据库连接异常
	 */
	List<String> getAllTableName() throws SQLException;

	/**
	 * 获取所有表对象
	 * @return 表对象
	 * @exception SQLException 异常
	 */
	List<ITable> getAllTable() throws SQLException;

	/**
	 * 获取表对象
	 * @param tableName 表名
	 * @return 表对象
	 * @exception SQLException 异常
	 */
	ITable getTable(String tableName) throws SQLException;

	/**
	 * 创建表
	 * @param tableBuilder 表建造者
	 * @exception SQLException 创建表失败
	 */
	void createTable(ITableBuilder tableBuilder) throws SQLException;

	/**
	 * 删除表
	 * @param tableName 表名
	 * @exception SQLException 异常
	 */
	void dropTable(String tableName) throws SQLException;

}