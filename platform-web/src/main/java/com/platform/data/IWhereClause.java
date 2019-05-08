package com.platform.data;

import java.util.Date;

/**
 * 过滤,排序条件
 */
public interface IWhereClause {

	/**
	 * 等于
	 * @param field 字段
	 * @param str 字符串
	 * @return this
	 */
	IWhereClause equals(String field, String str);

	/**
	 * 等于
	 * @param field 字段
	 * @param number 数字
	 * @return this
	 */
	IWhereClause equals(String field, Number number);

	/**
	 * 不等于
	 * @param field 字段
	 * @param str 字符串
	 * @return this
	 */
	IWhereClause notEquals(String field, String str);

	/**
	 * 不等于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	IWhereClause notEquals(String field, Number number);

	/**
	 * 以什么开始
	 * @param field 字段
	 * @param str 字符串
	 * @return this
	 */
	IWhereClause startWith(String field, String str);

	/**
	 * 模糊
	 * @param field 子弹
	 * @param str 字符串
	 * @return this
	 */
	IWhereClause like(String field, String str);

	/**
	 * 数字介于两者之间
	 * @param field 字段
	 * @param min 小数值
	 * @param max 大数值
	 * @return this
	 */
	IWhereClause between(String field, Number min, Number max);

	/**
	 * 时间介于两者之间
	 * @param field 字段
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return this
	 */
	IWhereClause between(String field, Date start, Date end);

	/**
	 * 大于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	IWhereClause gt(String field, Number number);

	/**
	 * 大于等于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	IWhereClause gte(String field, Number number);

	/**
	 * 小于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	IWhereClause lt(String field, Number number);

	/**
	 * 小于等于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	IWhereClause lte(String field, Number number);

	/**
	 * in查询
	 * @param field 字段
	 * @param numbers 数值
	 * @return this
	 */
	IWhereClause in(String field, Number... numbers);

	/**
	 * in查询
	 * @param field 字段
	 * @param strs 字符串
	 * @return this
	 */
	IWhereClause in(String field, String... strs);

	/**
	 * 值为null
	 * @param field 字段
	 * @return this
	 */
	IWhereClause isNull(String field);

	/**
	 * 值不为空
	 * @param field 字段
	 * @return this
	 */
	IWhereClause isNotNull(String field);

	/**
	 * 降序
	 * @param field 字段
	 * @return this
	 */
	IWhereClause desc(String field);

	/**
	 * 升序
	 * @param field 字段
	 * @return this
	 */
	IWhereClause asc(String field);
	
}
