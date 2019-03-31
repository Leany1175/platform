package com.platform.data.mysql;

import com.platform.data.column.IColumnType;

@Deprecated
public enum MysqlColumnType implements IColumnType {

	CHAR,VARCHAR,INTEGER,LONG,DECIMAL,DOUBLE,FLOAT,DATE,DATETIME;

	@Override
	public String type() {
		return toString().toLowerCase();
	}

}
