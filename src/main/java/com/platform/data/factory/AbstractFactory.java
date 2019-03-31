package com.platform.data.factory;

import com.platform.data.IDatabase;
import com.platform.data.builder.IAggregationBuilder;
import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.IQueryBuilder;
import com.platform.data.builder.ITableBuilder;

import javax.sql.DataSource;
import java.sql.SQLException;

public interface AbstractFactory {

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
	 * 创建表建造者
	 * @return 表建造者
	 */
	ITableBuilder createTableBuilder();

	/**
	 * 创建列建造者
	 * @return 列建造者
	 */
	IColumnBuilder createColumnBuilder();

	/**
	 * 创建查询建造者
	 * @return 查询建造者
	 */
	IQueryBuilder createQueryBuilder();

	/**
	 * 创建聚合建造者
	 * @return 聚合建造者
	 */
	IAggregationBuilder createAggregationBuilder();

}
