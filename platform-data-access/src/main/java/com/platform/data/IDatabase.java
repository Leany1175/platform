package com.platform.data;

import com.platform.data.builder.AggregationBuilder;
import com.platform.data.builder.QueryBuilder;
import com.platform.data.builder.TableBuilders;

import java.io.File;
import java.sql.SQLException;
import java.util.Set;

/**
 * 数据库
 */
public interface IDatabase {

	/**
	 * 返回所有表名
	 * @return 表名
	 * @exception SQLException 数据库连接异常
	 */
	Set<String> getAllTableName() throws SQLException;

	/**
	 * 表名是否存在
	 * @param tableName 表名
	 * @return true:表示改表存在
	 * @throws SQLException 异常
	 */
	default boolean existsTable(String tableName) throws SQLException {
		if (tableName == null || tableName.trim().isEmpty()) {
			throw new NullPointerException("表名不能为空");
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
	 * 创建表
	 * @param tableBuilders 表建造者
	 */
	boolean createTable(TableBuilders tableBuilders);

	/**
	 * 删除表
	 * @param tableName 表名
	 */
	boolean dropTable(String tableName);

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
	 * 导出
	 * @param option 导出选项
	 * @return 文件对象
	 */
	File export(ExportOption option, String... tableName);

	/**
	 * 导入文件
	 * @param option 导入参数
	 * @param file 文件对象
	 */
	void importFile(ExportOption option, File file);

}
