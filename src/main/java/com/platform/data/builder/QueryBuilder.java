package com.platform.data.builder;

import java.util.Date;

/**
 * 查询条件
 */
public interface QueryBuilder {

	/**
	 * 字段名称,列名
	 * @param field 列名
	 * @return this
	 */
	QueryBuilder field(String field);

	/**
	 * 等于
	 * @param str 字符串
	 * @return this
	 */
	QueryBuilder equals(String str);

	/**
	 * 不等于
	 * @param str 字符串
	 * @return this
	 */
	QueryBuilder notEquals(String str);

	/**
	 * 不等于
	 * @param number 值
	 * @return this
	 */
	QueryBuilder notEquals(Number number);

	/**
	 * 以什么开始
	 * @param str 字符串
	 * @return this
	 */
	QueryBuilder startWith(String str);

	/**
	 * 模糊
	 * @param str 字符串
	 * @return this
	 */
	QueryBuilder like(String str);

	/**
	 * 数字介于两者之间
	 * @param min 小数值
	 * @param max 大数值
	 * @return this
	 */
	QueryBuilder between(Number min, Number max);

	/**
	 * 时间介于两者之间
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return this
	 */
	QueryBuilder between(Date start, Date end);

	/**
	 * 大于
	 * @param number 值
	 * @return this
	 */
	QueryBuilder gt(Number number);

	/**
	 * 大于等于
	 * @param number 值
	 * @return this
	 */
	QueryBuilder gte(Number number);

	/**
	 * 小于
	 * @param number 值
	 * @return this
	 */
	QueryBuilder lt(Number number);

	/**
	 * 小于等于
	 * @param number 值
	 * @return this
	 */
	QueryBuilder lte(Number number);

	/**
	 * 值为null
	 * @return this
	 */
	QueryBuilder isNull();

	/**
	 * 值不为空
	 * @return
	 */
	QueryBuilder isNotNull();

}
