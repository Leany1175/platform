package com.platform.data.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {

    private static Logger logger = LoggerFactory.getLogger(JdbcUtils.class);

    private JdbcUtils() {}

    /**
     * 关闭连接
     * @param conn 连接
     */
    public static void close(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            logger.error("关闭数据库连接失败", e);
        }
    }

    /**
     * 关闭连接
     * @param ps 预编译
     */
    public static void close(PreparedStatement ps) {
        try {
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException e) {
            logger.error("关闭预编译失败", e);
        }
    }

    /**
     * 关闭连接
     * @param rs 连接
     */
    public static void close(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            logger.error("关闭结果集失败", e);
        }
    }

    /**
     * 关闭所有
     * @param conn 数据库连接
     * @param ps 预编译
     * @param rs 结果集
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        close(rs);
        close(ps);
        close(conn);
    }

    /**
     * execute sql
     * @param dataSource ds
     * @param sql sql
     * @exception SQLException sql exception
     */
    public static void executeUpdate(DataSource dataSource, String sql) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            logger.debug("get connection");
            conn = dataSource.getConnection();
            logger.debug("prepare statement");
            ps = conn.prepareStatement(sql);
            logger.debug("execute update");
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("executeUpdate exception:{}", sql, e);
            throw e;
        } finally {
            close(ps);
            close(conn);
            logger.debug("close");
        }
    }

}
