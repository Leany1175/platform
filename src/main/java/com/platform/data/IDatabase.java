package com.platform.data;

import com.platform.data.builder.IAggregationBuilder;
import com.platform.data.builder.IQueryBuilder;
import com.platform.data.builder.ITableBuilder;
import com.platform.data.entity.ExportOption;

import java.io.File;
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
	 * 表名是否存在
	 * @param tableName 表名
	 * @return true:表示改表存在
	 * @throws SQLException 异常
	 */
	default boolean existsTable(String tableName) throws SQLException {
		return getAllTableName().contains(tableName);
	}

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

	/**
	 * 查询
	 * @param queryBuilder 查询条件
	 * @return 查询结果
	 * @exception SQLException 异常
	 */
	ISearchResult query(IQueryBuilder queryBuilder) throws SQLException;

	/**
	 * TODO 聚合
	 * @param aggregationBuilder 条件
	 */
	IAggregationResult aggregation(IAggregationBuilder aggregationBuilder);

	/**
	 * 导出
	 * @param option 导出选项
	 * @return 文件对象
	 */
	File export(ExportOption option, String... tableName);

	/**
	 * 导入文件
	 * @param file 文件对象
	 */
	void importFile(File file);

	/**
	 * 导入sql文件
	 * @param file 文件
	 */
	void importSql(File file);

}
