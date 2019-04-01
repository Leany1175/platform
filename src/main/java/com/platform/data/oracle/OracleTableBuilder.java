package com.platform.data.oracle;

import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.base.BaseTableBuilder;
import com.platform.data.entity.Column;
import com.platform.data.entity.Table;
import com.platform.data.mysql.MysqlColumnBuilder;

import java.util.ArrayList;
import java.util.List;

public class OracleTableBuilder extends BaseTableBuilder {

	public OracleTableBuilder() {
	}

	public OracleTableBuilder(Table table) {
		this.name = table.getName();
		this.start = table.getStartWith();
		// 列
		List<Column> columnList = table.getColumnList();
		List<IColumnBuilder> columnBuilderList = new ArrayList<>(columnList.size());
		columnList.forEach(column -> new OracleColumnBuilder(column));
		this.columnBuilderList = columnBuilderList;
	}


	@Override
	public String build(boolean format) {
		// TODO oracle建表语句
		return null;
	}

}
