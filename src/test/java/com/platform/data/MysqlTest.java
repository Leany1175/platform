package com.platform.data;

import java.sql.SQLException;
import java.util.List;

import com.platform.data.builder.IDatabase;
import com.platform.data.factory.AbstractDatabaseFactory;
import com.platform.data.mysql.MysqlDatabaseFactory;

public class MysqlTest {

	public static void main(String[] args) throws SQLException {
		AbstractDatabaseFactory factory = new MysqlDatabaseFactory();
		IDatabase database = factory.createDatabase("jdbc:mysql://localhost:3306/test?characterEncoding=utf8",
				"com.mysql.jdbc.Driver", "root", "123456");

		List<String> list = database.getAllTableName();
		list.forEach(System.out :: println);

	}

}
