package com.platform.data.oracle;

import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.base.BaseTable;
import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class OracleTable extends BaseTable {

    private static Logger logger = LoggerFactory.getLogger(OracleTable.class);

    public OracleTable(DataSource dataSource, String tableName) {
        super(dataSource, tableName);
    }

    @Override
    protected IColumnBuilder createBuilder() {
        return new OracleColumnBuilder();
    }

    @Override
    public void addColumn(ColumnBuilders columnBuilders) throws SQLException {
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" add (")
                .append(columnBuilders.build(createBuilder()))
                .append(")");
        logger.debug("添加列:{}", buffer);
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public void modifyColumn(ColumnBuilders columnBuilders) throws SQLException{
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" modify (")
                .append(columnBuilders.build(createBuilder()))
                .append(")");
        logger.debug("修改列:{}", buffer);
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }
}
