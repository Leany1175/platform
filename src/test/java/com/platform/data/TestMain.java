package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.platform.data.builder.AggregationBuilders;
import com.platform.data.builder.IAggregationBuilder;
import com.platform.data.factory.AbstractDatabaseFactory;
import com.platform.data.mysql.MysqlDatabaseFactory;

public class TestMain {

	public static void main(String[] args) throws Exception{
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");

		AbstractDatabaseFactory databaseFactory = new MysqlDatabaseFactory();
		IDatabase database = databaseFactory.createDatabase(dataSource);
		ITable table = database.getTable("user_info");

		IAggregationBuilder aggregationBuilder = AggregationBuilders.mysql().name("").field("").subAggregation(null);
		System.out.println("finish");
	}

}
