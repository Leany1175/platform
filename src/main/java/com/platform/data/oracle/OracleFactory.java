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
		return new OracleDatabase(dataSource);
	}

	@Override
	public IDatabase createDatabase(Object object) throws Exception {
		if (object instanceof DataSource) {
			createDatabase((DataSource) object);
		}
		throw new Exception("未知数据源");
	}

	@Override
	public ITableBuilder createTableBuilder() {
		return new OracleTableBuilder();
	}

	@Override
	public IColumnBuilder createColumnBuilder() {
		return new OracleColumnBuilder();
	}

	@Override
	public IQueryBuilder createQueryBuilder() {
		return new OracleQueryBuilder();
	}

	@Override
	public IAggregationBuilder createAggregationBuilder() {
		return new OracleAggregationBuilder();
	}

}
