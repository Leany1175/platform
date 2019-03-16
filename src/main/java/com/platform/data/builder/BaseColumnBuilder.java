package com.platform.data.builder;

import com.platform.data.Column;

public abstract class BaseColumnBuilder implements IColumnBuilder {

	protected Column column = new Column();

	@Override
	public IColumnBuilder name(String name) {
		column.setName(name);
		return this;
	}

	@Override
	public IColumnBuilder type(IColumnType columnType) {
		column.setColumnType(columnType.type());
		// 所有类型默认长度为11
		column.setLength(11);
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

}
