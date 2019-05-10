package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;
import oracle.jdbc.OracleDriver;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

public class IDatabaseTest {

    @Test
    public void getAllTableNameTest() throws SQLException {
        DruidDataSource oracleDataSource = new DruidDataSource();
        oracleDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        oracleDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        oracleDataSource.setUsername("test");
        oracleDataSource.setPassword("123456");

        DruidDataSource mysqlDataSource = new DruidDataSource();
        mysqlDataSource.setUrl("jdbc:mysql://192.168.240.128:3306/test?characterEncoding=utf8&useSSL=true");
        mysqlDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        mysqlDataSource.setUsername("root");
        mysqlDataSource.setPassword("123456");

        IDatabase oracle = new OracleDatabase(oracleDataSource);
        IDatabase mysql = new MysqlDatabase(mysqlDataSource);

        System.out.println(oracle.getAllTableName());
        System.out.println(mysql.getAllTableName());
    }

}
