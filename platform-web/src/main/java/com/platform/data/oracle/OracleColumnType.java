package com.platform.data.oracle;

import com.platform.data.column.IColumnType;

@Deprecated
public enum OracleColumnType implements IColumnType {

	CHAR,VARCHAR2,INTEGER,LONG,DECIMAL,DOUBLE,FLOAT,DATE,TIMESTAMP;

	@Override
	public String type() {
		return toString().toLowerCase();
	}

}
