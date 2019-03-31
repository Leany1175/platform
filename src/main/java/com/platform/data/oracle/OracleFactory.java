package com.platform.data.oracle;

import javax.sql.DataSource;

import com.platform.data.IDatabase;
import com.platform.data.builder.IAggregationBuilder;
import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.IQueryBuilder;
import com.platform.data.builder.ITableBuilder;
import com.platform.data.factory.AbstractFactory;

public class OracleFactory implements AbstractFactory {

	@Override
	public IDatabase createDatabase(DataSource dataSource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDatabase createDatabase(Object object) throws Exception {
		if (object instanceof DataSource) {
			createDatabase((DataSource) object);
		}
		throw new Exception("未知数据源");
	}

	@Override
	public IDatabase createDatabase(String url, String driverClassName, String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITableBuilder createTableBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IColumnBuilder createColumnBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQueryBuilder createQueryBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAggregationBuilder createAggregationBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
