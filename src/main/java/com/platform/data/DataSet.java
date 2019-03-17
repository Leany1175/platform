package com.platform.data;

import java.util.Iterator;
import java.util.List;

public interface DataSet {

	/**
	 * 总列数
	 * @return 列数
	 */
	int totalColumn();

	/**
	 * 列信息
	 * @return 列
	 */
	List<Column> columnList();

	/**
	 * 列迭代器
	 * @return 迭代器
	 */
	Iterator<Column> columIterator();

	/**
	 * 总行数
	 * @return 行
	 */
	int totalRow();

	/**
	 * 行列表
	 * @return  行
	 */
	List<Row> rowList();

	/**
	 * 行迭代器
	 * @return
	 */
	Iterator<Row> rowIterator();

}
