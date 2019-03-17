package com.platform.data.util;

import com.platform.data.Column;
import com.platform.data.DatabaseType;
import com.platform.data.builder.ITableBuilder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JdbcUtil {

	private JdbcUtil() {}

	/**
	 * 执行sql语句
	 * @param dataSource 数据源
	 * @param sql sql语句
	 * @return 行数
	 * @throws SQLException 异常
	 */
	public static int executeUpdate(DataSource dataSource, String sql) throws SQLException{
		// 获取连接对象
		Connection conn = dataSource.getConnection();
		// 预编译
		PreparedStatement ps = conn.prepareStatement(sql);
		int count = ps.executeUpdate();
		// 关闭
		close(conn, ps);
		return count;
	}

	/**
	 * 执行sql语句
	 * @param dataSource 数据源
	 * @param tableBuilder 表
	 * @return 行数
	 * @throws SQLException 异常
	 */
	public static int executeUpdate(DataSource dataSource, ITableBuilder tableBuilder) throws SQLException{
		return executeUpdate(dataSource, tableBuilder.build());
	}

	/**
	 * 获取所有表名
	 * @param dataSource 数据源
	 * @return 表名集合
	 * @throws SQLException 连接异常
	 */
	public static List<String> getAllTableName(DataSource dataSource) throws SQLException {
		Connection connection = dataSource.getConnection();
		ResultSet rs = connection.getMetaData().getTables(null, null, null, new String[]{ "table" });
		// 集合储存表名
		List<String> list = new LinkedList<>();
		while (rs.next()) {
			list.add(rs.getString("table_name"));
		}
		// 关闭
		close(rs);
		close(connection);
		return list;
	}

	/**
	 * 关闭连接
	 * @param conn 连接对象
	 * @throws SQLException 异常
	 */
	public static void close(Connection conn) throws SQLException{
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}

	/**
	 * 关闭预编译
	 * @param ps 预编译
	 * @throws SQLException 异常
	 */
	public static void close(PreparedStatement ps) throws SQLException{
		if (ps != null && !ps.isClosed()) {
			ps.close();
		}
	}

	/**
	 * 关闭结果集
	 * @param rs 结果集
	 * @throws SQLException 异常
	 */
	public static void close(ResultSet rs) throws SQLException{
		if (rs != null && !rs.isClosed()) {
			rs.close();
		}
	}

	/**
	 * 关闭
	 * @param conn 连接
	 * @param ps 预编译
	 * @throws SQLException 异常
	 */
	public static void close(Connection conn, PreparedStatement ps) throws SQLException{
		close(ps);
		close(conn);
	}

	/**
	 * 关闭
	 * @param conn 连接
	 * @param ps 预编译
	 * @param rs 结果集
	 * @throws SQLException 异常
	 */
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException{
		close(rs);
		close(ps);
		close(conn);
	}

	/**
	 * 判断数据库类型
	 * @param dataSource 数据源
	 * @return 数据库类型
	 * @throws SQLException 异常
	 */
	public static DatabaseType judgeDatabaseType(DataSource dataSource) throws SQLException{
		// 驱动类
		String driverName = dataSource.getConnection().getMetaData().getDriverName();
		if ("mysql".equalsIgnoreCase(driverName)) {
			return DatabaseType.MYSQL;
		}
		return null;
	}

	/**
	 * 返回列数
	 * @param dataSource 数据源
	 * @param tableName 表名
	 * @return 列数
	 */
	public static int columnCount(DataSource dataSource, String tableName) throws SQLException{
		Connection conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from " + tableName);
		// 总列数
		int count = ps.getMetaData().getColumnCount();
		close(conn, ps);
		return count;
	}

	/**
	 * 获取列集合
	 * @param dataSource 数据源
	 * @param tableName 表名
	 * @return 列集合
	 * @throws SQLException 异常
	 */
	public static List<Column> columnList(DataSource dataSource, String tableName) throws SQLException{
		Connection conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from " + tableName);
		ResultSetMetaData metaData = ps.getMetaData();
		int count = metaData.getColumnCount();
		// 主键列名
		List<String> pkList = getPKColumnName(dataSource, tableName);
		List<Column> columnList = new ArrayList<>(count);
		for (int i = 1; i < count + 1; i++) {
			Column column = new Column();
			column.setName(metaData.getColumnName(i));
			column.setColumnType(metaData.getColumnTypeName(i).toLowerCase());
			column.setColumnClassName(metaData.getColumnClassName(i));
			column.setLength(metaData.getPrecision(i));
			column.setPrecision(metaData.getScale(i));
			column.setPK(pkList.contains(metaData.getColumnName(i)));
			column.setAuto(metaData.isAutoIncrement(i));
			column.setNull(metaData.isNullable(i) != 0);
			columnList.add(column);
		}
		return columnList;
	}

	/**
	 * 获取主键列名
	 * @param dataSource 数据源
	 * @param tableName 表名
	 * @return 列名集合
	 * @exception SQLException 异常
	 */
	public static List<String> getPKColumnName(DataSource dataSource, String tableName) throws SQLException{
		Connection conn = dataSource.getConnection();
		ResultSet rs = conn.getMetaData().getPrimaryKeys(null, null, tableName);
		List<String> list = new LinkedList<>();
		while (rs.next()) {
			list.add(rs.getString("column_name"));
		}
		return list;
	}

}
