package com.platform.data.mysql;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.platform.data.IDatabase;
import com.platform.data.factory.AbstractDatabaseFactory;

public class MysqlDatabaseFactory implements AbstractDatabaseFactory {

	@Override
	public IDatabase createDatabase(DataSource dataSource) {
		return new MysqlDatabase(dataSource);
	}

	@Override
	public IDatabase createDatabase(Object object) throws Exception{
		if (object instanceof DataSource) {
			createDatabase((DataSource) object);
		}
		throw new Exception("未知数据源对象");
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
