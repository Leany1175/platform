package com.platform.data.base;

import com.platform.data.ITable;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.entity.Row;
import com.platform.data.query.ISearchResult;
import com.platform.data.query.QueryBuilder;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public abstract class BaseTable implements ITable {

    private static Logger logger = LoggerFactory.getLogger(BaseTable.class);
    /** 数据源 */
    protected DataSource dataSource;
    /** 表名 */
    protected final String TABLE_NAME;

    public BaseTable(DataSource dataSource, String tableName) {
        this.dataSource = dataSource;
        this.TABLE_NAME = tableName;
    }

    /**
     * 生成列建造者
     * @return 列建造者
     */
    protected abstract IColumnBuilder createBuilder();

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public void addColumn(ColumnBuilders columnBuilders) throws SQLException {
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" add column ")
                .append(columnBuilders.build(createBuilder()));

        logger.debug("新增列,SQL:{}", buffer.toString());
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public void modifyColumn(ColumnBuilders columnBuilders) throws SQLException{
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" modify ")
                .append(columnBuilders.build(createBuilder()));
        logger.debug("更新列:{}", buffer);
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public void renameColumn(String columnName, ColumnBuilders columnBuilders) throws SQLException{
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" rename column ")
                .append(columnName)
                .append(" to ")
                .append(columnBuilders.build().getColumnName());
        logger.debug("更改列名:{}", buffer.toString());
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public void dropColumn(String columnName) throws SQLException {
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append("  drop column ")
                .append(columnName);
        logger.debug("删除列:{}", buffer);
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public ISearchResult query(QueryBuilder queryBuilder) throws SQLException {
        return null;
    }

    @Override
    public int insert(Row row) throws SQLException {
        if (row == null || row.size() == 0) {
            throw new NullPointerException("插入的行至少一列");
        }
        // 列
        StringBuffer keys = new StringBuffer();
        // 值, 用"?"替代
        StringBuffer values = new StringBuffer();
        row.forEach((key, value) -> {
            keys.append(" ,").append(key);
            values.append(" ,").append("?");
        });
        // 拼接sql语句
        StringBuffer sql = new StringBuffer("insert into ")
                .append(TABLE_NAME)
                .append("(")
                .append(keys.delete(0, 2))
                .append(") values(")
                .append(values.delete(0, 2))
                .append(")");
        logger.debug("insert sql:{}", sql);

        Connection conn = null;
        PreparedStatement ps = null;
        // 受影响行数
        int count = 0;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql.toString());
            // 下标,从1开始
            int i = 1;
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                ps.setObject(i, entry.getValue());
                i++;
            }
            count = ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("insert failed", e);
            throw e;
        } finally {
            JdbcUtils.close(ps);
            JdbcUtils.close(conn);
        }
        return count;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
