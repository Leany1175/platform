package com.platform.data.mysql;

import com.platform.data.builder.BaseTableBuilder;

public class MysqlTableBuilder extends BaseTableBuilder {

	@Override
	public String build(boolean format) {
		if (format) {
			String sql = "create table " + name + "(\n?\n)";
			StringBuffer buffer = new StringBuffer();
			columnBuilderList.forEach(builder -> buffer.append("\t\t" + builder.build() + ",\n"));
			return sql.replaceFirst("\\?", buffer.delete(buffer.length() - 2, buffer.length()).toString());
		}

		// sql语句
		String sql = "create table " + name + "(?)";
		StringBuffer buffer = new StringBuffer();
		columnBuilderList.forEach(builder -> buffer.append(builder.build() + ","));
		return sql.replaceFirst("\\?", buffer.delete(buffer.length() - 1, buffer.length()).toString());
	}

}
