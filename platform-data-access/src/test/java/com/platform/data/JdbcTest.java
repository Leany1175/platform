package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

public class JdbcTest {

    @Test
    public void jdbcTest() throws Exception{

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=true");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");

        Connection conn = druidDataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from demo_table");
        ResultSetMetaData metaData = ps.getMetaData();
        int count = metaData.getColumnCount();
        for (int i = 1, len = count + 1; i < len; i++) {
            System.out.println("getColumnName:" + metaData.getColumnName(i));
            System.out.println("getColumnTypeName:" + metaData.getColumnTypeName(i));
            System.out.println("getColumnClassName:" + metaData.getColumnClassName(i));
            System.out.println("---------------------------------");
        }

    }


}
