package com.platform.data.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import com.platform.data.IDatabase;
import com.platform.data.builder.IAggregationBuilder;
import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.IQueryBuilder;
import com.platform.data.builder.ITableBuilder;
import com.platform.data.factory.AbstractFactory;

import javax.sql.DataSource;

public class MysqlFactory implements AbstractFactory {

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

	@Override
	public ITableBuilder createTableBuilder() {
		return new MysqlTableBuilder();
	}

	@Override
	public IColumnBuilder createColumnBuilder() {
		return new MysqlColumnBuilder();
	}

	@Override
	public IQueryBuilder createQueryBuilder() {
		return new MysqlQueryBuilder();
	}

	@Override
	public IAggregationBuilder createAggregationBuilder() {
		return new MysqlAggregationBuilder();
	}

}
