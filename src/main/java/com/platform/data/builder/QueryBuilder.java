package com.platform.data.builder;

import java.util.Date;
import java.util.List;

/**
 * 查询条件
 */
public interface QueryBuilder {

	/**
	 * 表名
	 * @param name 表名
	 * @return this
	 */
	QueryBuilder tableName(String name);

	/**
	 * 字段名
	 * @param field 字段名
	 * @return this
	 */
	QueryBuilder field(String field);

	/**
	 * 字段名
	 * @param fields 字段名
	 * @return this
	 */
	QueryBuilder field(String... fields);

	/**
	 * 字段名
	 * @param fields 字段名
	 * @return this
	 */
	QueryBuilder field(List<String> fields);

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
	 * 等于
	 * @param field 字段
	 * @param str 字符串
	 * @return this
	 */
	QueryBuilder equals(String field, String str);

	/**
	 * 等于
	 * @param field 字段
	 * @param number 数字
	 * @return this
	 */
	QueryBuilder equals(String field, Number number);

	/**
	 * 不等于
	 * @param field 字段
	 * @param str 字符串
	 * @return this
	 */
	QueryBuilder notEquals(String field, String str);

	/**
	 * 不等于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	QueryBuilder notEquals(String field, Number number);

	/**
	 * 以什么开始
	 * @param field 字段
	 * @param str 字符串
	 * @return this
	 */
	QueryBuilder startWith(String field, String str);

	/**
	 * 模糊
	 * @param field 子弹
	 * @param str 字符串
	 * @return this
	 */
	QueryBuilder like(String field, String str);

	/**
	 * 数字介于两者之间
	 * @param field 字段
	 * @param min 小数值
	 * @param max 大数值
	 * @return this
	 */
	QueryBuilder between(String field, Number min, Number max);

	/**
	 * 时间介于两者之间
	 * @param field 字段
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return this
	 */
	QueryBuilder between(String field, Date start, Date end);

	/**
	 * 大于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	QueryBuilder gt(String field, Number number);

	/**
	 * 大于等于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	QueryBuilder gte(String field, Number number);

	/**
	 * 小于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	QueryBuilder lt(String field, Number number);

	/**
	 * 小于等于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	QueryBuilder lte(String field, Number number);

	/**
	 * in查询
	 * @param field 字段
	 * @param numbers 数值
	 * @return this
	 */
	QueryBuilder in(String field, Number... numbers);

	/**
	 * in查询
	 * @param field 字段
	 * @param strs 字符串
	 * @return this
	 */
	QueryBuilder in(String field, String... strs);

	/**
	 * 值为null
	 * @param field 字段
	 * @return this
	 */
	QueryBuilder isNull(String field);

	/**
	 * 值不为空
	 * @param field 字段
	 * @return this
	 */
	QueryBuilder isNotNull(String field);

	/**
	 * 降序
	 * @param field 字段
	 * @return this
	 */
	QueryBuilder desc(String field);

	/**
	 * 升序
	 * @param field 字段
	 * @return this
	 */
	QueryBuilder asc(String field);

	/**
	 * 构建
	 * @return sql条件
	 */
	String build();

	/**
	 * 查询条件
	 * @return 查询条件
	 */
	List<ConditionBean> getQueryCondition();

	/**
	 * 排序条件
	 * @return 条件
	 */
	List<ConditionBean> getOrderCondition();

}
