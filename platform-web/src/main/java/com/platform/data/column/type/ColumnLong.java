package com.platform.data.column.type;

import com.platform.data.column.IColumnType;

@Deprecated
public class ColumnLong implements IColumnType {

	@Override
	public String type() {
		return "long";
	}

}
