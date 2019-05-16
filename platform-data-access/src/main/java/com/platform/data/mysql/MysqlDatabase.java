package com.platform.data.mysql;

import com.platform.data.base.BaseDatabase;
import com.platform.data.ITable;
import com.platform.data.builder.table.TableBuilders;
import com.platform.data.util.JdbcUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

public class MysqlDatabase extends BaseDatabase {

    public MysqlDatabase(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void createTable(TableBuilders tableBuilders) throws SQLException{
        JdbcUtils.executeUpdate(dataSource, tableBuilders.buildSql(new MysqlTableBuilder()));
    }

    @Override
    public ITable getTable(String tableName) {
        return new MysqlTable(dataSource, tableName);
    }

}
