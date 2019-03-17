package com.platform.data;

import java.sql.SQLException;
import java.util.List;

import com.platform.data.builder.ColumnBuilders;
import com.platform.data.builder.ITableBuilder;
import com.platform.data.builder.TableBuilders;
import com.platform.data.mysql.MysqlColumnType;
import org.junit.Test;

import com.platform.data.builder.IDatabase;
import com.platform.data.factory.AbstractDatabaseFactory;
import com.platform.data.mysql.MysqlDatabaseFactory;

public class DatabaseTest {

	private AbstractDatabaseFactory factory = new MysqlDatabaseFactory();
	private IDatabase database = factory.createDatabase("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=true",
			"com.mysql.jdbc.Driver", "root", "123456");

	@Test
	public void getAllTableNameTest()throws SQLException {
		List<String> list = database.getAllTableName();
		list.forEach(System.out :: println);
	}

	@Test
	public void addTableTest() throws SQLException{
		ITableBuilder tableBuilder = TableBuilders.mysql()
				.tableName("users")
				.addColumn(
						ColumnBuilders.mysql().name("user_id").type(MysqlColumnType.INTEGER).length(11).isNull(false)
								.primaryKey(true).autoIncrement(true)
				)
				.addColumn(ColumnBuilders.mysql().name("user_name").type(MysqlColumnType.VARCHAR).length(32).isNull(false))
				.addColumn(ColumnBuilders.mysql().name("age").type(MysqlColumnType.INTEGER).length(11).defaultValue(18))
				.addColumn(ColumnBuilders.mysql().name("height").type(MysqlColumnType.DECIMAL).length(10, 5).isNull(false));
		database.addTable(tableBuilder);
	}

}
