package com.platform.data.builder.base;

import com.platform.data.builder.IColumnBuilder;
import com.platform.data.builder.ITableBuilder;
import com.platform.data.entity.Column;
import com.platform.data.entity.Table;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseTableBuilder implements ITableBuilder {

	/** 表名 */
	protected String name;
	/** 默认从1开始 */
	protected long start = 1L;
	/** 列 */
	protected List<IColumnBuilder> columnBuilderList = new LinkedList<>();

	@Override
	public ITableBuilder tableName(String tableName) {
		this.name = tableName;
		return this;
	}

	@Override
	public ITableBuilder addColumn(IColumnBuilder columnBuilder) {
		columnBuilderList.add(columnBuilder);
		return this;
	}

	@Override
	public ITableBuilder startWith(long start) {
		this.start = start;
		return this;
	}

	@Override
	public String build() {
		return build(false);
	}

	@Override
	public Table buildTable() {
		Table table = new Table();
		table.setName(name);
		table.setStartWith(start);
		List<Column> columnList = new ArrayList<>(columnBuilderList.size());
		columnBuilderList.forEach(columnBuilder -> columnList.add(columnBuilder.buildColumn()));
		table.setColumnList(columnList);
		return table;
	}

	/**
	 * 验证表名非空,至少存在一列
	 */
	protected void check() {
		if (name == null) {
			throw new NullPointerException("表名不能为空");
		}
		if (columnBuilderList.size() == 0) {
			throw new NullPointerException("至少存在一列");
		}
	}

}
