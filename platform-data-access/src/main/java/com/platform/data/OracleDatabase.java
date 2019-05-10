package com.platform.data;

import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OracleDatabase extends BaseDatabase {

    private static Logger logger = LoggerFactory.getLogger(OracleDatabase.class);

    public OracleDatabase(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Set<String> getAllTableName() throws SQLException {
        Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("select t.table_name from user_tables t");
        logger.info("数据库获取所有表名");
        ResultSet rs = ps.executeQuery();

        Set<String> tableSet = new HashSet<>();
        while (rs.next()) {
            tableSet.add(rs.getString("table_name"));
        }
        logger.info("数据库获取所有表名结果:{}", tableSet);
        // 关闭
        JdbcUtils.close(conn, ps, rs);
        return tableSet;
    }
}
