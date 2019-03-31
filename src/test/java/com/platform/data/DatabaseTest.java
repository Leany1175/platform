package com.platform.data;

import com.platform.data.factory.AbstractFactory;
import com.platform.data.mysql.MysqlFactory;
import org.junit.Test;

public class DatabaseTest {

	AbstractFactory mysqlAbstractFactory = new MysqlFactory();

	@Test
	public void getAllTableNameTest() {

	}

}
