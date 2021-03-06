package com.platform.data.builder;

import com.platform.data.column.IColumnType;
import com.platform.data.entity.Column;

/**
 * 列建造者
 */
public interface IColumnBuilder {

	/**
	 * 名字
	 * @param name 列名
	 * @return this
	 */
	IColumnBuilder name(String name);

	/**
	 * 列类型
	 * @param columnType 列类型
	 * @return this
	 */
	IColumnBuilder type(IColumnType columnType);

	/**
	 * 列长度
	 * @param length 列长度
	 * @return this
	 */
	IColumnBuilder length(int length);

	/**
	 * 列长度
	 * @param length 列长度
	 * @param precision 列精度
	 * @return this
	 */
	IColumnBuilder length(int length, int precision);

	/**
	 * 是否是主键
	 * @param pk true表示是主键
	 * @return this
	 */
	IColumnBuilder primaryKey(boolean pk);

	/**
	 * 是否允许为空
	 * @param isNull true:允许为空
	 * @return this
	 */
	IColumnBuilder isNull(boolean isNull);

	/**
	 * 是否自增
	 * @param autoIncrement true:自增
	 * @return this
	 */
	IColumnBuilder autoIncrement(boolean autoIncrement);

	/**
	 * 默认值
	 * @param value 值
	 * @return this
	 */
	IColumnBuilder defaultValue(String value);

	/**
	 * 默认值
	 * @param value 值
	 * @return this
	 */
	IColumnBuilder defaultValue(Number value);

	/**
	 * 构建生成sql语句
	 * @return sql语句
	 */
	String build();

	/**
	 * 获取列
	 * @return 列
	 */
	Column buildColumn();

}
