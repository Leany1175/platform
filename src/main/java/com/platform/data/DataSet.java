package com.platform.data;

import java.util.Iterator;

public interface DataSet {

	int totalColumn();

	Iterator<Column> columIterator();

	int totalRow();

	Iterator<Row> rowIterator();

}
