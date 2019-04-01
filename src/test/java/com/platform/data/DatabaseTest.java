package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;
import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.ITableBuilder;
import com.platform.data.column.type.*;
import com.platform.data.factory.AbstractFactory;
import com.platform.data.mysql.MysqlFactory;
import com.platform.data.oracle.OracleFactory;
import oracle.jdbc.driver.OracleDriver;
import org.junit.Test;

import javax.sql.DataSource;

public class DatabaseTest {

	private static DruidDataSource mysql = new DruidDataSource();
	private static DruidDataSource oracle = new DruidDataSource();

	static {
		mysql.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8");
		mysql.setDriverClassName("com.mysql.jdbc.Driver");
		mysql.setUsername("root");
		mysql.setPassword("123456");

		oracle.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		oracle.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		oracle.setUsername("test");
		oracle.setPassword("123456");
	}

	private AbstractFactory mysqlFactory = new MysqlFactory();
	private AbstractFactory oracleFactory = new OracleFactory();

	@Test
	public void getAllTableNameTest() throws Exception{
		IDatabase mysqlDatabase = mysqlFactory.createDatabase(mysql);
		//mysqlDatabase.getAllTableName().forEach(System.out :: println);
		ITableBuilder mysqlTableBuilder = mysqlFactory.createTableBuilder().tableName("demo_table").startWith(10L)
				.addColumn(mysqlFactory.createColumnBuilder().name("id").type(new ColumnInteger()).length(11).primaryKey(true).autoIncrement(true).isNull(false))
				.addColumn(mysqlFactory.createColumnBuilder().name("age").type(new ColumnInt()).length(4).defaultValue(18).isNull(false))
				.addColumn(mysqlFactory.createColumnBuilder().name("heigth").type(new ColumnDouble()).defaultValue(66.66))
				.addColumn(mysqlFactory.createColumnBuilder().name("len_mete").type(new ColumnFloat()))
				.addColumn(mysqlFactory.createColumnBuilder().name("sex").type(new ColumnChar()).length(4).defaultValue("男").isNull(false))
				.addColumn(mysqlFactory.createColumnBuilder().name("name").type(new ColumnVarchar()).length(32))
				.addColumn(mysqlFactory.createColumnBuilder().name("description").type(new ColumnText()));

		System.out.println(mysqlTableBuilder.build());
		System.out.println(mysqlTableBuilder.build(true));

		IDatabase oracleDatabase = oracleFactory.createDatabase(oracle);
//		oracleDatabase.getAllTableName().forEach(System.out :: println);
	}

}
