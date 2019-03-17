package com.platform.data;

import com.platform.data.builder.ColumnBuilders;
import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.IDatabase;
import com.platform.data.factory.AbstractDatabaseFactory;
import com.platform.data.mysql.MysqlColumnType;
import com.platform.data.mysql.MysqlDatabaseFactory;
import org.junit.Test;

import java.sql.SQLException;

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

}
