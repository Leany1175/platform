package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;
import com.platform.data.factory.AbstractFactory;
import com.platform.data.mysql.MysqlFactory;
import com.platform.data.oracle.OracleFactory;
import org.junit.Test;

import javax.sql.DataSource;

public class DatabaseTest {

	private static DruidDataSource mysql = new DruidDataSource();
	private static DruidDataSource oracle = new DruidDataSource();

	static {
		mysql.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8");
		mysql.setDriverClassName("com.mysql.jdbc.Driver");
		mysql.setUsername("root");
		mysql.setPassword("123456");
	}

	private AbstractFactory mysqlFactory = new MysqlFactory();
	private AbstractFactory oracleFactory = new OracleFactory();

	@Test
	public void getAllTableNameTest() {
		IDatabase mysqlDatabase = mysqlFactory.createDatabase(mysql);
		IDatabase oracleDatabase = oracleFactory.createDatabase(oracle);

	}

}
