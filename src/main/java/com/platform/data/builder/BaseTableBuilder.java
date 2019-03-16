package com.platform.data.builder;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseTableBuilder implements ITableBuilder {

	/** 表名 */
	protected String name;

	/** true:创建表如果该表存在就先删除 */
	protected boolean replace = false;

	/** 列 */
	protected List<IColumnBuilder> columnBuilderList = new LinkedList<>();

	@Override
	public ITableBuilder tableName(String tableName) {
		name = tableName;
		return this;
	}

	@Override
	public ITableBuilder addColumn(IColumnBuilder columnBuilder) {
		columnBuilderList.add(columnBuilder);
		return this;
	}

	@Override
	public ITableBuilder replace(boolean isReplace) {
		replace = isReplace;
		return this;
	}

	@Override
	public String build() {
		return build(false);
	}


}
