package com.platform.data.factory;

import com.platform.data.IDatabase;

import javax.sql.DataSource;
import java.sql.SQLException;

public interface AbstractDatabaseFactory {

	/**
	 * 创建数据库对象
	 * @param dataSource 数据源
	 * @return 数据库对象
	 */
	IDatabase createDatabase(DataSource dataSource);

	/**
	 * 创建数据库对象
	 * @param object obj
	 * @return 数据库对象
	 * @exception Exception 对象不兼容
	 */
	IDatabase createDatabase(Object object) throws Exception;

	/**
	 * 创建数据库对象
	 * @param url url
	 * @param driverClassName 驱动类名
	 * @param username 用户名
	 * @param password 密码
	 * @return 数据库对象
	 */
	@Deprecated
	IDatabase createDatabase(String url, String driverClassName, String username, String password);



}
