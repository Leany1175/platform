package com.platform.data;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.platform.data.builder.IDatabase;
import com.platform.data.factory.AbstractDatabaseFactory;
import com.platform.data.mysql.MysqlDatabaseFactory;

public class DatabaseTest {

	private AbstractDatabaseFactory factory = new MysqlDatabaseFactory();
	private IDatabase database = factory.createDatabase("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=true",
			"com.mysql.jdbc.Driver", "root", "123456");

	@Test
	public void getAllTableNameTest()throws SQLException {
		List<String> list = database.getAllTableName();
		list.forEach(System.out :: println);
	}

}
