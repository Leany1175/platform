package com.platform.data;

import java.util.Iterator;

public interface ITable {

	/**
	 * 获取表名
	 */
	String getTableName();

	/**
	 * 添加列
	 */
	void addColumn();

	/**
	 * 更改列
	 */
	void modifyColumn();

	/**
	 * 删除列
	 */
	void deleteColumn();

	/**
	 * 列数
	 * @return 几列
	 */
	int columnCount();

	/**
	 * 返回一个迭代器
	 * @return 迭代器
	 */
	Iterator<Column> columnIterator();

}
