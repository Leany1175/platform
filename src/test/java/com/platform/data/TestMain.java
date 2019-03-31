package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.platform.data.builder.IAggregationBuilder;
import com.platform.data.factory.AbstractFactory;
import com.platform.data.mysql.MysqlFactory;

public class TestMain {

	public static void main(String[] args) throws Exception{
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");

		AbstractFactory databaseFactory = new MysqlFactory();
		IDatabase database = databaseFactory.createDatabase(dataSource);
		ITable table = database.getTable("user_info");
		IAggregationBuilder aggregationBuilder = databaseFactory.createAggregationBuilder().name("").field("").subAggregation(null);
		System.out.println("finish");
	}

}
