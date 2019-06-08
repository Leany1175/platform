package com.platform.data.mysql;

import com.platform.data.base.BaseDatabase;
import com.platform.data.ITable;
import com.platform.data.builder.table.TableBuilder;
import com.platform.data.builder.table.TableBuilders;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlDatabase extends BaseDatabase {

    private static Logger logger = LoggerFactory.getLogger(MysqlDatabase.class);

    public MysqlDatabase(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void createTable(TableBuilder tableBuilder) throws SQLException {
        String mysql = new MysqlTableBuilder().build(tableBuilder, true);
        logger.debug("-------- create table sql --------");
        logger.debug(mysql);
        logger.debug("-------- create table sql --------");

        JdbcUtils.executeUpdate(dataSource, mysql);
    }

    @Override
    public ITable getTable(String tableName) {
        return new MysqlTable(dataSource, tableName);
    }

}
