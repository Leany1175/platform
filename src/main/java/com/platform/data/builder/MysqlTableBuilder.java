package com.platform.data.builder;

import java.util.LinkedList;
import java.util.List;

public class MysqlTableBuilder extends BaseTableBuilder {

	@Override
	public String build(boolean format) {
		if (format) {
			String sql = "create table " + name + "(\n?\n)";
			StringBuffer buffer = new StringBuffer();
			columnBuilderList.forEach(builder -> {
				buffer.append("\t\t" + builder.build() + ",\n");
			});
			return sql.replaceFirst("\\?", buffer.delete(buffer.length() - 2, buffer.length()).toString());
		}

//		StringBuffer buffer = new StringBuffer("create table table_name()");
//		columnBuilderList.forEach(builder -> {
//
//		});
		return null;
	}

}
