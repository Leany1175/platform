package com.platform.data;

import com.platform.data.builder.MysqlTableBuilder;
import com.platform.data.builder.TableBuilders;
import com.platform.data.db.MysqlTable;
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
