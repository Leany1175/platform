package com.platform.data.builder;

import com.platform.data.mysql.MysqlTableBuilder;
import com.platform.data.oracle.OracleTableBuilder;

public class TableBuilders {

	private TableBuilders() {}

	public static ITableBuilder mysql() {
		return new MysqlTableBuilder();
	}

	public static ITableBuilder oracle() {
		return new OracleTableBuilder();
	}

}
