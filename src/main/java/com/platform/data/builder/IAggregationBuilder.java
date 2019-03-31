package com.platform.data.builder;

import com.platform.data.IWhereClause;

/**
 * 聚合条件
 */
public interface IAggregationBuilder extends IWhereClause {

	/**
	 * 别名
	 * @param name 别名
	 * @return this
	 */
	IAggregationBuilder name(String name);

	/**
	 * 字段
	 * @param field 字段名
	 * @return this
	 */
	IAggregationBuilder field(String field);

	/**
	 * 子聚合
	 * @param aggregationBuilder 聚合
	 * @return this
	 */
	IAggregationBuilder subAggregation(IAggregationBuilder aggregationBuilder);

}
