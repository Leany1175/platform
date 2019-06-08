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
	 * TODO table
	 * @param tableName table name
	 * @return table
	 * @exception SQLException exception
	 */
	ITable getTable(String tableName) throws SQLException;

	/**
	 * create table
	 * @param tableBuilder table
	 * @throws SQLException exeception
	 */
	void createTable(TableBuilder tableBuilder) throws SQLException;

	/**
	 * delete table
	 * @param tableName name
	 * @exception SQLException exeception
	 */
	void dropTable(String tableName) throws SQLException;

	/**
	 * TODO export
	 * @param option 导出选项
	 * @return 文件对象
	 */
	File exportFile(ExportOption option, String... tableName);

	/**
	 * TODO import
	 * @param option 导入参数
	 * @param file 文件对象
	 */
	void importFile(ExportOption option, File file);

}
