package com.platform.data.base;

import com.platform.data.ITable;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.query.IQueryBuilder;
import com.platform.data.query.ISearchResult;
import com.platform.data.query.QueryBuilder;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

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

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
