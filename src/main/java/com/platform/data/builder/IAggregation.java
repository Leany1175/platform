package com.platform.data.builder;

public interface IAggregation {

	/**
	 * 名称
	 * @param name 名称
	 * @return
	 */
	IAggregation name(String name);

	/**
	 * 别名
	 * @param field 字段名称
	 * @return
	 */
	IAggregation field(String field);

}
