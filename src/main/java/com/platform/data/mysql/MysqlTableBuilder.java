package com.platform.data.mysql;

import com.platform.data.builder.base.BaseTableBuilder;

public class MysqlTableBuilder extends BaseTableBuilder {

	@Override
	public String build(boolean format) {
		// 表名非空,列名大于0检查
		check();
		if (format) {
			// 格式化
			String sql = "create table " + name + "(\n?\n)";
			StringBuffer buffer = new StringBuffer();
			// 列
			columnBuilderList.forEach(builder -> buffer.append("\t\t" + builder.build() + ",\n"));
			// 删除多余的","和"\n"
			buffer.delete(buffer.length() - 2, buffer.length());
			return sql.replaceFirst("\\?", buffer.toString()) + " auto_increment " + start + " default charset utf8";
		}
		// 不格式化,sql语句
		String sql = "create table " + name + "(?)";
		StringBuffer buffer = new StringBuffer();
		columnBuilderList.forEach(builder -> buffer.append(builder.build() + ","));
		return sql.replaceFirst("\\?", buffer.delete(buffer.length() - 1, buffer.length()).toString())
				+ " auto_increment " + start + " default charset utf8";
	}

}
