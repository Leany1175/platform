package com.platform.data.entity;

import com.platform.data.entity.Column;
import com.platform.data.entity.Row;

import java.io.Serializable;
import java.util.List;

public class DataSetEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 数据库名 */
    private String databaseName;
    /** 表名 */
    private String tableName;
    /** 字段信息 */
    private List<Column> columnList;
    /** 数据行 */
    private List<Row> rowList;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    public List<Row> getRowList() {
        return rowList;
    }

    public void setRowList(List<Row> rowList) {
        this.rowList = rowList;
    }
}
