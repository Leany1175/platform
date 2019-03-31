package com.platform.data.mysql;

import javax.sql.DataSource;

import com.platform.data.base.BaseTable;

public class MysqlTable extends BaseTable {

	public MysqlTable(DataSource dataSource) {
		super(dataSource);
	}

	public MysqlTable(DataSource dataSource, String name) {
		super(dataSource, name);
	}

}
