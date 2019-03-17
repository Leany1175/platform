package com.platform.data.builder;

import com.platform.data.ITable;

import java.sql.SQLException;
import java.util.List;

/**
 * 数据库
 */
public interface IDatabase {

	/**
	 * 返回所有表名
	 * @return 表名
	 * @exception SQLException 数据库连接异常
	 */
	List<String> getAllTableName() throws SQLException;

	/**
	 * 获取所有表对象
	 * @return 表对象
	 */
	List<ITable> getAllTable();

	/**
	 * 获取表对象
	 * @param tableName 表名
	 * @return 表对象
	 */
	ITable getTable(String tableName);

	/**
	 * 创建表
	 * @param tableBuilder 表建造者
	 */
	void addTable(ITableBuilder tableBuilder);

	/**
	 * 删除表
	 * @param tableName 表名
	 */
	void dropTable(String tableName);

}
