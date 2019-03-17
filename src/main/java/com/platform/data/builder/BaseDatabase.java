package com.platform.data.builder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import com.platform.data.ITable;

public abstract class BaseDatabase implements IDatabase {

	/** 数据源 */
	private DataSource dataSource;

	public BaseDatabase(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<String> getAllTableName() {
		try {
			Connection connection = dataSource.getConnection();
			ResultSet rs = connection.getMetaData().getTables(null, null, null, new String[]{ "table" });
			// 集合储存表名
			List<String> list = new LinkedList<>();
			while (rs.next()) {
				list.add(rs.getString("table_name"));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ITable> getAllTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTable(ITableBuilder tableBuilder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropTable(String tableName) {
		// TODO Auto-generated method stub
		
	}

	

}
