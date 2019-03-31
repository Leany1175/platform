package com.platform.data.builder;

import com.platform.data.WhereClauseImpl;

public abstract class BaseAggregationBuilder extends WhereClauseImpl implements IAggregationBuilder {

	/** 别名 */
	protected String name;
	/** 字段名(列名) */
	protected String field;
	/** 子聚合 */
	protected IAggregationBuilder subAggregationBuilder;

	@Override
	public IAggregationBuilder name(String name) {
		return null;
	}

	@Override
	public IAggregationBuilder field(String field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAggregationBuilder subAggregation(IAggregationBuilder aggregationBuilder) {
		// TODO Auto-generated method stub
		return null;
	}

}
