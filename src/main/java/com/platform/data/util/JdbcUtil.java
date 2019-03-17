package com.platform.data.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class JdbcUtil {

	private JdbcUtil() {}

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
	 * @param rs 结果集
	 * @throws SQLException 异常
	 */
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException{
		close(rs);
		close(ps);
		close(conn);
	}

}
