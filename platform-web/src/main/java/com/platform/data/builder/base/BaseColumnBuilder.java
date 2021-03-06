package com.platform.data.builder.base;

import com.platform.data.builder.IColumnBuilder;
import com.platform.data.column.IColumnType;
import com.platform.data.entity.Column;

public abstract class BaseColumnBuilder implements IColumnBuilder {

	protected Column column = new Column();

	protected BaseColumnBuilder() {}

	protected BaseColumnBuilder(Column column) {
		this.column = column;
	}

	@Override
	public IColumnBuilder name(String name) {
		column.setName(name);
		return this;
	}

	@Override
	public IColumnBuilder type(IColumnType columnType) {
		column.setColumnType(columnType.type());
		return this;
	}

	@Override
	public IColumnBuilder length(int length) {
		column.setLength(length);
		return this;
	}

	@Override
	public IColumnBuilder length(int length, int precision) {
		column.setLength(length);
		column.setPrecision(precision);
		return this;
	}

	@Override
	public IColumnBuilder primaryKey(boolean pk) {
		column.setPK(pk);
		return this;
	}

	@Override
	public IColumnBuilder isNull(boolean isNull) {
		column.setNull(isNull);
		return this;
	}

	@Override
	public IColumnBuilder autoIncrement(boolean autoIncrement) {
		column.setAuto(autoIncrement);
		return this;
	}

	@Override
	public IColumnBuilder defaultValue(String value) {
		column.setDefaultValue(value);
		return this;
	}

	@Override
	public IColumnBuilder defaultValue(Number value) {
		column.setDefaultValue(value);
		return this;
	}

	@Override
	public Column buildColumn() {
		return column;
	}

	/**
	 * 列名和列类型不能为空
	 */
	protected void check() {
		if (column.getName() == null || column.getName().trim().isEmpty()) {
			throw new NullPointerException("列名不能为空");
		}
		if (column.getColumnType() == null || column.getColumnType().trim().isEmpty()) {
			throw new NullPointerException("列类型不能为空");
		}
	}

}
