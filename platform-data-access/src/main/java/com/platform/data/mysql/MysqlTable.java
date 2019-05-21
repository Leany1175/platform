package com.platform.data.mysql;

import com.alibaba.fastjson.JSON;
import com.platform.data.base.SearchResult;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.base.BaseTable;
import com.platform.data.entity.ColumnConstruction;
import com.platform.data.entity.Condition;
import com.platform.data.query.IQueryBuilder;
import com.platform.data.query.ISearchResult;
import com.platform.data.query.QueryBuilder;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MysqlTable extends BaseTable {

    private static Logger logger = LoggerFactory.getLogger(MysqlTable.class);

    public MysqlTable(DataSource dataSource, String tableName) {
        super(dataSource, tableName);
    }

    @Override
    protected IColumnBuilder createBuilder() {
        return new MysqlColumnBuilder();
    }

    @Override
    protected IQueryBuilder createQueryBuild() {
        return new MysqlQueryBuilder();
    }

    @Override
    public void renameColumn(String columnName, ColumnBuilders columnBuilders) throws SQLException {
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" change column ")
                .append(columnName)
                .append(" ")
                .append(columnBuilders.build(createBuilder()));
        logger.debug("更改列名:{}", buffer);
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public ISearchResult query(QueryBuilder queryBuilder) throws SQLException {
        // 查询结果
        SearchResult result = new SearchResult();
        // 表名
        result.setTableName(TABLE_NAME);

        // sql查询语句, select * from ??? where ...
        String sql = queryBuilder.build(createQueryBuild());
        sql = sql.replaceAll("\\?\\?\\?", TABLE_NAME);
        logger.debug("query sql:{}", sql);

        List<Object> objectList = queryBuilder.values();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            // ? set value
            for (int i = 0, len = objectList.size(); i < len; i++) {
                ps.setObject(i + 1, objectList.get(i));
            }

            // 解析列
            List<ColumnConstruction> columnList = analyzeColumn(ps);
            System.out.println(JSON.toJSONString(columnList, true));
            // 查询
            rs = ps.executeQuery();
            while (rs.next()) {
                // TODO 结果
                System.out.println(rs.getObject(1));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            JdbcUtils.close(conn, ps, rs);
        }
        return result;
    }

}
