package com.platform.data.db;

import com.platform.data.IColumn;
import com.platform.data.ITable;
import com.platform.data.builder.ColumnBuilders;
import com.platform.data.builder.IColumnBuilder;
import com.platform.data.entity.ColumnConstruction;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

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
    public boolean addColumn(ColumnBuilders columnBuilders) {
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" add column ")
                .append(columnBuilders.build(createBuilder()));

        logger.debug("新增列,SQL:{}", buffer.toString());
        return JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public boolean modifyColumn(ColumnBuilders columnBuilders) {
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" modify ")
                .append(columnBuilders.build(createBuilder()));
        logger.debug("更新列:{}", buffer);
        return JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public boolean renameColumn(String oldName, String newName) {
        return false;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
