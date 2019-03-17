package com.platform.data;

import com.platform.data.builder.*;

public class TestMain {

	public static void main(String[] args) {

		ITableBuilder tableBuilder = TableBuilders.mysql()
				.tableName("users")
				.addColumn(
						ColumnBuilders.mysql()
								.name("id")
								.type(MysqlColumnType.INTEGER)
								.length(11)
								.primaryKey(true)
								.isNull(false)
								.autoIncrement(true)
				)
				.addColumn(
						ColumnBuilders.mysql()
								.name("heigth")
								.type(MysqlColumnType.DECIMAL)
								.length(6,3)
								.defaultValue(1.64)
								.isNull(false)
				)
				.addColumn(
						ColumnBuilders.mysql()
								.name("name")
								.type(MysqlColumnType.VARCHAR)
								.length(32)
								.defaultValue("张三")
								.isNull(true)
				)
				.addColumn(
						ColumnBuilders.mysql()
								.name("sex")
								.type(MysqlColumnType.INTEGER)
								.isNull(true)
				);

		System.out.println(tableBuilder.build(true));


	}

}
