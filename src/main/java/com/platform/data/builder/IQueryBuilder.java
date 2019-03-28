package com.platform.data.builder;

import com.platform.data.entity.QueryCondition;

import java.util.Date;
import java.util.List;

/**
 * 查询条件
 */
public interface IQueryBuilder {

	/**
	 * 表名
	 * @param name 表名
	 * @return this
	 */
	IQueryBuilder tableName(String name);

//	/**
//	 * 需要查询的 字段名
//	 * @param field 字段名
//	 * @return this
//	 */
//	QueryBuilder field(String field);

	/**
	 * 需要查询的 字段名
	 * @param fields 字段名
	 * @return this
	 */
	IQueryBuilder field(String... fields);

	/**
	 * 需要查询的 字段名
	 * @param fields 字段名
	 * @return this
	 */
	IQueryBuilder field(List<String> fields);

	/**
	 * 当前页
	 * @param currentPage 页号
	 * @return this
	 */
	IQueryBuilder currentPage(int currentPage);

	/**
	 * 条数
	 * @param size 条数
	 * @return this
	 */
	IQueryBuilder size(int size);

	/**
	 * 等于
	 * @param field 字段
	 * @param str 字符串
	 * @return this
	 */
	IQueryBuilder equals(String field, String str);

	/**
	 * 等于
	 * @param field 字段
	 * @param number 数字
	 * @return this
	 */
	IQueryBuilder equals(String field, Number number);

	/**
	 * 不等于
	 * @param field 字段
	 * @param str 字符串
	 * @return this
	 */
	IQueryBuilder notEquals(String field, String str);

	/**
	 * 不等于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	IQueryBuilder notEquals(String field, Number number);

	/**
	 * 以什么开始
	 * @param field 字段
	 * @param str 字符串
	 * @return this
	 */
	IQueryBuilder startWith(String field, String str);

	/**
	 * 模糊
	 * @param field 子弹
	 * @param str 字符串
	 * @return this
	 */
	IQueryBuilder like(String field, String str);

	/**
	 * 数字介于两者之间
	 * @param field 字段
	 * @param min 小数值
	 * @param max 大数值
	 * @return this
	 */
	IQueryBuilder between(String field, Number min, Number max);

	/**
	 * 时间介于两者之间
	 * @param field 字段
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return this
	 */
	IQueryBuilder between(String field, Date start, Date end);

	/**
	 * 大于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	IQueryBuilder gt(String field, Number number);

	/**
	 * 大于等于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	IQueryBuilder gte(String field, Number number);

	/**
	 * 小于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	IQueryBuilder lt(String field, Number number);

	/**
	 * 小于等于
	 * @param field 字段
	 * @param number 值
	 * @return this
	 */
	IQueryBuilder lte(String field, Number number);

	/**
	 * in查询
	 * @param field 字段
	 * @param numbers 数值
	 * @return this
	 */
	IQueryBuilder in(String field, Number... numbers);

	/**
	 * in查询
	 * @param field 字段
	 * @param strs 字符串
	 * @return this
	 */
	IQueryBuilder in(String field, String... strs);

	/**
	 * 值为null
	 * @param field 字段
	 * @return this
	 */
	IQueryBuilder isNull(String field);

	/**
	 * 值不为空
	 * @param field 字段
	 * @return this
	 */
	IQueryBuilder isNotNull(String field);

	/**
	 * 降序
	 * @param field 字段
	 * @return this
	 */
	IQueryBuilder desc(String field);

	/**
	 * 升序
	 * @param field 字段
	 * @return this
	 */
	IQueryBuilder asc(String field);

	/**
	 * 开启分页
	 * @param isPage true:使用分页
	 * @return this
	 */
	IQueryBuilder enablePage(boolean isPage);

//	/**
//	 * 获取表名
//	 * @return this
//	 */
//	String getTableName();

	/**
	 * 构建sql查询条件
	 * @return sql条件
	 */
	String build();

	/**
	 * 构建条数统计sql语句
	 * @return sql语句
	 */
	String buildCount();

//	/**
//	 * 查询条件
//	 * @return 查询条件
//	 */
//	List<ConditionBean> getQueryCondition();
//
//	/**
//	 * 排序条件
//	 * @return 条件
//	 */
//	List<ConditionBean> getOrderCondition();

	/**
	 * 获取查询条件
	 * @return 查询条件
	 */
	QueryCondition getQueryCondition();

}
