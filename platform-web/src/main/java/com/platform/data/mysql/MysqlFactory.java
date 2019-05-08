package com.platform.data.mysql;

import javax.sql.DataSource;

import com.platform.data.IDatabase;
import com.platform.data.builder.IAggregationBuilder;
import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.IQueryBuilder;
import com.platform.data.builder.ITableBuilder;
import com.platform.data.entity.Column;
import com.platform.data.entity.Table;
import com.platform.data.factory.AbstractFactory;

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
	public ITableBuilder createTableBuilder() {
		return new MysqlTableBuilder();
	}

	@Override
	public ITableBuilder createTableBuilder(Table table) {
		return new MysqlTableBuilder(table);
	}

	@Override
	public IColumnBuilder createColumnBuilder() {
		return new MysqlColumnBuilder();
	}

	@Override
	public IColumnBuilder createColumnBuilder(Column column) {
		return new MysqlColumnBuilder(column);
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
