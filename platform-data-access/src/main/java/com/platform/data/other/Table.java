package com.platform.data.other;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Table implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 表名 */
    private String tableName;
    /** 列 */
    private List<Column> columnList = new ArrayList<>();

    public Table(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 添加列
     * @param column 列
     * @return this
     */
    public Table addColumn(Column column) {
        columnList.add(column);
        return this;
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
}
