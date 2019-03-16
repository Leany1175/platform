package com.platform.data.builder;

public class ColumnBuilders {

	private ColumnBuilders(){}

	public static IColumnBuilder mysql() {
		return new MysqlColumnBuilder();
	}

	public static IColumnBuilder oracle() {
		return new OracleColumnBuilder();
	}

}
