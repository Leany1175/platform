package com.platform.data;

import com.platform.data.builder.ColumnBuilders;
import com.platform.data.builder.IDatabase;
import com.platform.data.builder.ITableBuilder;
import com.platform.data.builder.TableBuilders;
import com.platform.data.factory.AbstractDatabaseFactory;
import com.platform.data.mysql.MysqlColumnType;
import com.platform.data.mysql.MysqlDatabaseFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

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
	public void createTableTest() throws SQLException{
		ITableBuilder tableBuilder = TableBuilders.mysql()
				.tableName("users")
				.addColumn(
						ColumnBuilders.mysql().name("user_id").type(MysqlColumnType.INTEGER).length(11).isNull(false)
								.primaryKey(true).autoIncrement(true)
				)
				.addColumn(ColumnBuilders.mysql().name("user_name").type(MysqlColumnType.VARCHAR).length(32).isNull(false))
				.addColumn(ColumnBuilders.mysql().name("age").type(MysqlColumnType.INTEGER).length(11).defaultValue(18))
				.addColumn(ColumnBuilders.mysql().name("height").type(MysqlColumnType.DECIMAL).length(10, 5).isNull(false));
		database.createTable(tableBuilder);
	}

	@Test
	public void dropTableTest() throws SQLException {
		database.dropTable("users");
	}

}
