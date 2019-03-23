package com.platform.data;

import com.alibaba.fastjson.JSON;
import com.platform.data.builder.*;
import com.platform.data.factory.AbstractDatabaseFactory;
import com.platform.data.mysql.MysqlColumnType;
import com.platform.data.mysql.MysqlDatabaseFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

public class TableTest {

	private AbstractDatabaseFactory factory = new MysqlDatabaseFactory();
	private IDatabase database = factory.createDatabase("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=true",
			"com.mysql.jdbc.Driver", "root", "123456");

	@Test
	public void getTableNameTest() throws SQLException {
		ITable table = database.getTable("users");
		IColumnBuilder columnBuilder = ColumnBuilders.mysql().name("create_date").type(MysqlColumnType.DATETIME);
		table.addColumn(columnBuilder);
	}

	@Test
	public void modifyColumnTest() throws SQLException{
		ITable table = database.getTable("users");
		IColumnBuilder columnBuilder = ColumnBuilders.mysql().name("sex").type(MysqlColumnType.INTEGER).isNull(false);
		System.out.println(columnBuilder.build());
//		table.modifyColumn("sex1", columnBuilder);
		table.modifyColumn(columnBuilder);
	}

	@Test
	public void deleteColumnTest() throws SQLException{
		ITable table = database.getTable("users");
		table.deleteColumn("sex");
	}

	@Test
	public void columnCountTest() throws SQLException{
		ITable table = database.getTable("users");
		System.out.println(table.columnCount());
	}

	@Test
	public void columnListTest() throws SQLException{
		ITable table = database.getTable("users");
		// 行
		Row row = new Row();
		row.put(new Column("user_id", true), 1);
		row.put("user_name", "小六");
		row.put("age", 24);
		row.put("height", 66.665);
		row.put("create_date", new Date());
		int count = table.executeUpdate(row);
		System.out.println(count);
	}

}
