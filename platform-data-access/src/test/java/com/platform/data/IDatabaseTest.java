package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.platform.data.builder.TableBuilders;
import org.junit.Test;

import java.sql.SQLException;

public class IDatabaseTest {

    private static DruidDataSource oracleDataSource = new DruidDataSource();
    private static DruidDataSource mysqlDataSource = new DruidDataSource();

    private IDatabase oracle = new OracleDatabase(oracleDataSource);
    private IDatabase mysql = new MysqlDatabase(mysqlDataSource);

    static {
        oracleDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        oracleDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        oracleDataSource.setUsername("test");
        oracleDataSource.setPassword("123456");

        mysqlDataSource.setUrl("jdbc:mysql://192.168.240.128:3306/test?characterEncoding=utf8&useSSL=true");
        mysqlDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        mysqlDataSource.setUsername("root");
        mysqlDataSource.setPassword("123456");
    }

    @Test
    public void getAllTableNameTest() throws SQLException {
        System.out.println(oracle.getAllTableName());
        System.out.println(mysql.getAllTableName());
    }

    @Test
    public void createTableTest() throws SQLException{
//        Table table = new Table("user_info")
//                .addColumn(new Column("id", ""));

        TableBuilders tableBuilder = new TableBuilders()
                .tableName("user_info");

//        oracle.createTable();
    }

}
