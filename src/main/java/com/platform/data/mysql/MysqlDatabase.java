package com.platform.data.mysql;

import com.platform.data.builder.BaseDatabase;

import javax.sql.DataSource;

public class MysqlDatabase extends BaseDatabase {

	public MysqlDatabase(DataSource dataSource) {
		super(dataSource);
	}

}
