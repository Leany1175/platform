package com.platform.data.mysql;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.platform.data.builder.IDatabase;
import com.platform.data.factory.AbstractDatabaseFactory;

public class MysqlDatabaseFactory implements AbstractDatabaseFactory {

	@Override
	public IDatabase createDatabase(DataSource dataSource) {
		return new MysqlDatabase(dataSource);
	}

	@Override
	public IDatabase createDatabase(String url, String driverClassName, String username, String password) {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return createDatabase(dataSource);
	}

}
