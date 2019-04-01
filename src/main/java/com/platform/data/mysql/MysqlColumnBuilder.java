package com.platform.data.mysql;

import com.platform.data.builder.base.BaseColumnBuilder;
import com.platform.data.entity.Column;

public class MysqlColumnBuilder extends BaseColumnBuilder {

	public MysqlColumnBuilder() {
	}

	public MysqlColumnBuilder(Column column) {
		super(column);
	}

	@Override
	public String build() {
		// 非空检查
		check();
		// 列名和列类型
		StringBuffer buffer = new StringBuffer(column.getName())
				.append(" ")
				.append(column.getColumnType());

		if ("decimal".equalsIgnoreCase(column.getColumnType())) {
			// DECIMAL
			buffer.append("(" + column.getLength() + "," + column.getPrecision() + ")");
		} else if ("varchar".equalsIgnoreCase(column.getColumnType())) {
			// varchar 默认长度255
			buffer.append("(" + column.getLength() + ")");
		} else {
			if (column.getLength() > 0) {
				buffer.append("(" + column.getLength() + ")");
			}
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
