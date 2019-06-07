package com.platform.data.oracle;

import com.platform.data.builder.table.TableBuilder;
import com.platform.data.builder.table.TableBuilders;
import com.platform.data.base.BaseDatabase;
import com.platform.data.ITable;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class OracleDatabase extends BaseDatabase {

    private static Logger logger = LoggerFactory.getLogger(OracleDatabase.class);

    public OracleDatabase(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Set<String> getAllTableName() throws SQLException {
        // jdbc query
        Set<String> tableSet = new LinkedHashSet<>();
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

            logger.debug("table names:{}", tableSet);

        } catch (SQLException e) {
            throw e;
        } finally {
            // close
            JdbcUtils.close(conn, ps, rs);
        }
        return tableSet;
    }

    @Override
    public void createTable(TableBuilders tableBuilders) throws SQLException{
//        JdbcUtils.executeUpdate(dataSource, tableBuilders.buildSql(new OracleTableBuilder()));
    }

    @Override
    public void createTable(TableBuilder tableBuilder) throws SQLException {

    }

    @Override
    public ITable getTable(String tableName) {
        return new OracleTable(dataSource, tableName);
    }

}
