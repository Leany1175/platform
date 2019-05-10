package com.platform.data;

import com.platform.data.builder.TableBuilder;

import javax.sql.DataSource;
import java.sql.SQLException;

public class MysqlDatabase extends BaseDatabase {

    public MysqlDatabase(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void createTable(TableBuilder tableBuilder) throws SQLException {


        super.createTable(tableBuilder);
    }
}
