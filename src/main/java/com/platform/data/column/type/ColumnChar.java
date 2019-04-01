package com.platform.data.column.type;

import com.platform.data.column.IColumnType;

public class ColumnChar implements IColumnType {

	@Override
	public String type() {
		return "char";
	}
}
