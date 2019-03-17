package com.platform.data.builder;

import com.platform.data.mysql.MysqlColumnBuilder;
import com.platform.data.oracle.OracleColumnBuilder;

public class ColumnBuilders {

	private ColumnBuilders(){}

	public static IColumnBuilder mysql() {
		return new MysqlColumnBuilder();
	}

	public static IColumnBuilder oracle() {
		return new OracleColumnBuilder();
	}

}
