package com.platform.data.builder;

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
	 * 是否替换
	 * @param isReplace true:创建表如果该表存在就先删除
	 * @return this
	 */
	ITableBuilder replace(boolean isReplace);

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

}
