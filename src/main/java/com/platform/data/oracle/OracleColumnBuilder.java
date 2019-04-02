package com.platform.data.oracle;

import com.platform.data.builder.base.BaseColumnBuilder;
import com.platform.data.entity.Column;

public class OracleColumnBuilder extends BaseColumnBuilder {

	public OracleColumnBuilder() {
	}

	public OracleColumnBuilder(Column column) {
		super(column);
	}

	@Override
	public String build() {
		StringBuffer buffer = new StringBuffer(column.getName())
				.append(" ")
				.append(column.getColumnType());

		return buffer.toString();
	}

}
