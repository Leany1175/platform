package com.platform.data;

import com.platform.data.builder.MysqlTableBuilder;
import com.platform.data.builder.TableBuilders;
import com.platform.data.util.JdbcUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

public class MysqlDatabase extends BaseDatabase {

    public MysqlDatabase(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean createTable(TableBuilders tableBuilders) {
        return JdbcUtils.executeUpdate(dataSource, tableBuilders.buildSql(new MysqlTableBuilder()));
    }

}
