package com.platform.data.builder;

import com.platform.data.mysql.MysqlAggregationBuilder;

public class AggregationBuilders {

	public static IAggregationBuilder mysql() {
		return new MysqlAggregationBuilder();
	}

}
