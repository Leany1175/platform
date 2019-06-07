package com.platform.data;

import com.platform.data.builder.table.TableBuilder;
import com.platform.data.builder.table.TableBuilders;
import com.platform.data.other.ExportOption;

import java.io.File;
import java.sql.SQLException;
import java.util.Set;

/**
 * database
 */
public interface IDatabase {

	/**
	 * get all table name
	 * @return table names
	 * @exception SQLException error
	 */
	Set<String> getAllTableName() throws SQLException;

	/**
	 * Verify that the table name exists
	 * @param tableName table name
	 * @return true:exists
	 * @throws SQLException error
	 */
	default boolean existsTable(String tableName) throws SQLException {
		if (tableName == null || tableName.trim().isEmpty()) {
			throw new NullPointerException("Table name is not allowed to be empty");
		}
		return getAllTableName().contains(tableName);
	}

	/**
	 * TODO 获取表对象
	 * @param tableName 表名
	 * @return 表对象
	 * @exception SQLException 异常
	 */
	ITable getTable(String tableName) throws SQLException;

	/**
	 * TODO 创建表
	 * @param tableBuilders 表建造者
	 * @exception SQLException 异常
	 */
	@Deprecated
	void createTable(TableBuilders tableBuilders) throws SQLException;

	/**
	 * TODO 创建表
	 * @param tableBuilder 表
	 * @throws SQLException 一串
	 */
	void createTable(TableBuilder tableBuilder) throws SQLException;

	/**
	 * TODO 删除表
	 * @param tableName 表名
	 * @exception SQLException 异常
	 */
	void dropTable(String tableName) throws SQLException;

//	/**
//	 * 查询
//	 * @param queryBuilder 查询条件
//	 * @return 查询结果
//	 * @exception SQLException 异常
//	 */
//	IQueryResult query(QueryBuilder queryBuilder) throws SQLException;
//
//	/**
//	 * TODO 聚合
//	 * @param aggregationBuilder 条件
//	 */
//	IAggregationResult aggregation(AggregationBuilder aggregationBuilder);

	/**
	 * TODO 导出
	 * @param option 导出选项
	 * @return 文件对象
	 */
	File export(ExportOption option, String... tableName);

	/**
	 * TODO 导入文件
	 * @param option 导入参数
	 * @param file 文件对象
	 */
	void importFile(ExportOption option, File file);

}
