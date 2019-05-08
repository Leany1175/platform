package com.platform.data.builder;

import com.platform.data.entity.Table;

/**
 * 表建造者
 */
public interface ITableBuilder {

	/**
	 * 表名
	 * @param tableName 表名
	 * @return this
	 */
	ITableBuilder tableName(String tableName);

	/**
	 * 添加列建造者
	 * @param columnBuilder 列建造者
	 * @return this
	 */
	ITableBuilder addColumn(IColumnBuilder columnBuilder);

	/**
	 * 自增从?开始
	 * @param start 值
	 * @return this
	 */
	ITableBuilder startWith(long start);

	/**
	 * 构建生成sql语句
	 * @return sql语句
	 */
	String build();

	/**
	 * 构建生成sql语句
	 * @param format true:格式化
	 * @return this
	 */
	String build(boolean format);

	/**
	 * 构建表信息
	 * @return 表信息
	 */
	Table buildTable();

}
