package com.platform.data.db;

import com.platform.data.builder.ColumnBuilders;
import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.MysqlColumnBuilder;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public class MysqlTable extends BaseTable{

    private static Logger logger = LoggerFactory.getLogger(MysqlTable.class);

    public MysqlTable(DataSource dataSource, String tableName) {
        super(dataSource, tableName);
    }

    @Override
    protected IColumnBuilder createBuilder() {
        return new MysqlColumnBuilder();
    }

    @Override
    public boolean renameColumn(String columnName, ColumnBuilders columnBuilders) {
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" change column ")
                .append(columnName)
                .append(" ")
                .append(columnBuilders.build(createBuilder()));
        logger.debug("更改列名:{}", buffer);
        return JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

}
