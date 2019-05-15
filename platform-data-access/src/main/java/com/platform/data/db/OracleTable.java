package com.platform.data.db;

import com.platform.data.builder.ColumnBuilders;
import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.OracleColumnBuilder;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public class OracleTable extends BaseTable{

    private static Logger logger = LoggerFactory.getLogger(OracleTable.class);

    public OracleTable(DataSource dataSource, String tableName) {
        super(dataSource, tableName);
    }

    @Override
    protected IColumnBuilder createBuilder() {
        return new OracleColumnBuilder();
    }

    @Override
    public boolean addColumn(ColumnBuilders columnBuilder) {
        StringBuffer buffer = new StringBuffer("alter table user_info add (")
                .append(columnBuilder.build(createBuilder()))
                .append(")");
        logger.debug("添加列:{}", buffer);
        return JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    //    @Override
//    public boolean addColumn(ColumnBuilders columnBuilder) {
//        return false;
//    }
}