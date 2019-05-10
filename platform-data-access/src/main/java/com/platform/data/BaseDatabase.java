package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.platform.data.builder.AggregationBuilder;
import com.platform.data.builder.QueryBuilder;
import com.platform.data.builder.TableBuilder;
import com.platform.data.entity.Table;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseDatabase implements IDatabase{

    private static Logger logger = LoggerFactory.getLogger(BaseDatabase.class);

    protected DataSource dataSource;

    public BaseDatabase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Set<String> getAllTableName() throws SQLException {
        Connection conn = dataSource.getConnection();
        DatabaseMetaData metaData = conn.getMetaData();
        logger.info("数据库获取所有表名");
        ResultSet rs = metaData.getTables(null, null, null, new String[] { "TABLE" });

        Set<String> tableSet = new HashSet<>();
        while (rs.next()) {
            tableSet.add(rs.getString("TABLE_NAME"));
        }
        logger.info("数据库获取所有表名结果:{}", tableSet);
        // 关闭
        JdbcUtils.close(rs);
        JdbcUtils.close(conn);
        return tableSet;
    }

    @Override
    public ITable getTable(String tableName) throws SQLException {
        return null;
    }

    @Override
    public void createTable(Table table) throws SQLException {

    }

    @Override
    public void dropTable(String tableName) throws SQLException {

    }

    @Override
    public IQueryResult query(QueryBuilder queryBuilder) throws SQLException {
        return null;
    }

    @Override
    public IAggregationResult aggregation(AggregationBuilder aggregationBuilder) {
        return null;
    }

    @Override
    public File export(ExportOption option, String... tableName) {
        return null;
    }

    @Override
    public void importFile(ExportOption option, File file) {

    }

    public void setDataSource(DruidDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
