package com.platform.data;

import com.mysql.jdbc.Driver;
import com.platform.data.builder.IDatabase;
import com.platform.data.factory.AbstractDatabaseFactory;
import com.platform.data.mysql.MysqlDatabaseFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

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
