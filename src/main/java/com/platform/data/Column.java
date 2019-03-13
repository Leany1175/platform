package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

/**
 * 列基本属性
 */
public class Column implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 列名 */
	private String name;
	/** 列类型名 */
	private String columnType;
	/** 列对应的类名 */
	private String columnClassName;
	/** 长度 */
	private int length;
	/** 精度 */
	private int precision;
	/** 默认值 */
	private String defaultValue;
	/** 是否是主键 */
	private boolean isPK = false;
	/** 是否是自增 */
	private boolean isAuto = false;
	/** 允许为空 */
	private boolean isNull = true;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnClassName() {
		return columnClassName;
	}

	public void setColumnClassName(String columnClassName) {
		this.columnClassName = columnClassName;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public boolean isPK() {
		return isPK;
	}

	public void setPK(boolean PK) {
		isPK = PK;
	}

	public boolean isAuto() {
		return isAuto;
	}

	public void setAuto(boolean auto) {
		isAuto = auto;
	}

	public boolean isNull() {
		return isNull;
	}

	public void setNull(boolean aNull) {
		isNull = aNull;
	}

	public static void main(String[] args) throws Exception{
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=true");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");

		Connection conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from test_table");
		ResultSetMetaData metaData = ps.getMetaData();
		int count = metaData.getColumnCount();

		for (int i = 1; i < count + 1; i++) {
			System.out.println("CatalogName:" + metaData.getCatalogName(i));
			System.out.println("ColumnClassName:" + metaData.getColumnClassName(i));
			System.out.println("ColumnLabel:" + metaData.getColumnLabel(i));
			System.out.println("ColumnName:" + metaData.getColumnName(i));
			System.out.println("ColumnTypeName:" + metaData.getColumnTypeName(i));
			System.out.println("ColumnType:" + metaData.getColumnType(i));
			System.out.println("TableName:" + metaData.getTableName(i));
			System.out.println("SchemaName:" + metaData.getSchemaName(i));
			System.out.println("ColumnDisplaySize:" + metaData.getColumnDisplaySize(i));
			System.out.println("Precision:" + metaData.getPrecision(i));
			System.out.println("Scale:" + metaData.getScale(i));
			System.out.println("-------------------------------------------------");
		}

		System.out.println(byte[].class);

		ps.close();
		conn.close();
		dataSource.close();

	}

}
