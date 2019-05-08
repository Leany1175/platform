package com.platform.data.column.type;

import com.platform.data.column.IColumnType;

public class ColumnText implements IColumnType {

	@Override
	public String type() {
		return "text";
	}
}
