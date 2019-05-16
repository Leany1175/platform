package com.platform.data;

import com.platform.data.builder.MysqlTableBuilder;
import com.platform.data.builder.OracleTableBuilder;
import com.platform.data.builder.TableBuilders;
import com.platform.data.db.MysqlTable;
import com.platform.data.db.OracleTable;
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
        // TODO jdbc query
        Set<String> tableSet = new HashSet<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("select t.table_name from user_tables t");
            rs = ps.executeQuery();
            while (rs.next()) {
                tableSet.add(rs.getString("table_name"));
            }

            logger.debug("数据库获取所有表名结果:{}", tableSet);

        } catch (SQLException e) {
            throw e;
        } finally {
            // 关闭
            JdbcUtils.close(conn, ps, rs);
        }
        return tableSet;
    }

    @Override
    public void createTable(TableBuilders tableBuilders) throws SQLException{
        JdbcUtils.executeUpdate(dataSource, tableBuilders.buildSql(new OracleTableBuilder()));
    }

    @Override
    public ITable getTable(String tableName) {
        return new OracleTable(dataSource, tableName);
    }

}
