package com.platform.data.mysql;

import com.platform.data.builder.BaseColumnBuilder;

public class MysqlColumnBuilder extends BaseColumnBuilder {

	@Override
	public String build() {
		StringBuffer buffer = new StringBuffer(column.getName())
				.append(" ")
				.append(column.getColumnType());
		// DECIMAL
		if ("decimal".equalsIgnoreCase(column.getColumnType())) {
			buffer.append("(" + column.getLength() + "," + column.getPrecision() + ")");
		} else {
			buffer.append("(" + column.getLength() + ")");
		}

		// 默认值
		if (column.getDefaultValue() != null) {
			buffer.append(" default");
			// 单引号
			if (column.getDefaultValue() instanceof Number) {
				buffer.append(" " + column.getDefaultValue());
			} else {
				buffer.append(" '" + column.getDefaultValue() + "'");
			}
		}

		// 主键
		if (column.isPK()) {
			buffer.append(" primary key");
		}

		//自增
		if (column.isAuto()) {
			buffer.append(" auto_increment");
		}

		// 允许为null
		if (column.isNull()) {
			buffer.append(" null");
		} else {
			buffer.append(" not null");
		}

		return buffer.toString();
	}

}
