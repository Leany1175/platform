package com.platform.data.builder;

import java.util.Date;
import java.util.List;

/**
 * 查询条件
 */
public interface QueryBuilder {

	/**
	 * 当前页
	 * @param currentPage 页号
	 * @return this
	 */
	QueryBuilder currentPage(int currentPage);

	/**
	 * 条数
	 * @param size 条数
	 * @return this
	 */
	QueryBuilder size(int size);

	/**
	 * 并且
	 * @param queryBuilder 查询条件
	 * @return this
	 */
	QueryBuilder and(QueryBuilder queryBuilder);

	/**
	 * 并且
	 * @param queryBuilders 查询条件
	 * @return this
	 */
	QueryBuilder and(QueryBuilder... queryBuilders);

	/**
	 * 并且
	 * @param queryBuilders 查询条件
	 * @return this
	 */
	QueryBuilder and(List<QueryBuilder> queryBuilders);

	/**
	 * 或者
	 * @param queryBuilder 查询条件
	 * @return this
	 */
	QueryBuilder or(QueryBuilder queryBuilder);

	/**
	 * 或者
	 * @param queryBuilders 查询条件
	 * @return this
	 */
	QueryBuilder or(QueryBuilder... queryBuilders);

	/**
	 * 或者
	 * @param queryBuilders 查询条件
	 * @return this
	 */
	QueryBuilder or(List<QueryBuilder> queryBuilders);

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

	/**
	 * 构建
	 * @return sql条件
	 */
	String build();

}
