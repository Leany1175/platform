package com.platform.data.builder;

public class TableBuilders {

	private TableBuilders() {}

	public static ITableBuilder mysql() {
		return new MysqlTableBuilder();
	}

	public static ITableBuilder oracle() {
		return new OracleTableBuilder();
	}

}
