package com.platform.data;

import java.util.Iterator;
import java.util.List;

public class SimpleDataSet implements DataSet {

	private List<Column> columnList;
	private List<Row> rowList;

	public SimpleDataSet(List<Column> columnList, List<Row> rowList) {
		this.columnList = columnList;
		this.rowList = rowList;
	}

	@Override
	public int totalColumn() {
		return columnList.size();
	}

	@Override
	public List<Column> columnList() {
		return columnList;
	}

	@Override
	public Iterator<Column> columIterator() {
		return columnList().iterator();
	}

	@Override
	public int totalRow() {
		return rowList.size();
	}

	@Override
	public List<Row> rowList() {
		return rowList;
	}

	@Override
	public Iterator<Row> rowIterator() {
		return rowList().iterator();
	}

}
