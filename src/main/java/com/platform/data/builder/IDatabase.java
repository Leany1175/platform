package com.platform.data.builder;

import com.platform.data.ITable;

import java.util.List;

/**
 * 数据库
 */
public interface IDatabase {

	/**
	 * 返回所有表名
	 * @return 表名
	 */
	List<String> getAllTableName();

	/**
	 * 获取所有表对象
	 * @return 表对象
	 */
	List<ITable> getAllTable();

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
