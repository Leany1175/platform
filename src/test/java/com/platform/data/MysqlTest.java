package com.platform.data;

import com.mysql.jdbc.Driver;
import com.platform.data.builder.IDatabase;
import com.platform.data.factory.AbstractDatabaseFactory;
import com.platform.data.mysql.MysqlDatabaseFactory;

import java.util.List;

public class MysqlTest {

	public static void main(String[] args) {
		AbstractDatabaseFactory factory = new MysqlDatabaseFactory();
		IDatabase database = factory.createDatabase("jdbc:mysql://localhost:3306/test?characterEncoding=utf8",
				"com.mysql.jdbc.Driver", "root", "123456");

		List<String> list = database.getAllTableName();
		list.forEach(System.out :: println);

	}

}
