package com.platform.data.factory;

import com.platform.data.IDatabase;

import javax.sql.DataSource;

public interface AbstractDatabaseFactory {

	/**
	 * 创建数据库对象
	 * @param dataSource 数据源
	 * @return 数据库对象
	 */
	IDatabase createDatabase(DataSource dataSource);

	/**
	 * 创建数据库对象
	 * @param url url
	 * @param driverClassName 驱动类名
	 * @param username 用户名
	 * @param password 密码
	 * @return 数据库对象
	 */
	IDatabase createDatabase(String url, String driverClassName, String username, String password);

}
