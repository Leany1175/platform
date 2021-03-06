package com.platform.data.model;

import com.platform.data.entity.Row;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Table implements Serializable {

    /** table name */
    private String tableName;
    /** colum list */
    private List<ColumnMeta> columnMetaList = new ArrayList<>();
    /** 数据列表 */
    private List<Object[]> rowList = new LinkedList<>();

    public Table addRow(Row row) {
        row.forEach((key, value) -> {
            columnMetaList.add(new ColumnMeta(key));
        });
        rowList.add(row.values().toArray());
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnMeta> getColumnMetaList() {
        return columnMetaList;
    }

    public void setColumnMetaList(List<ColumnMeta> columnMetaList) {
        this.columnMetaList = columnMetaList;
    }

    public List<Object[]> getRowList() {
        return rowList;
    }

    public void setRowList(List<Object[]> rowList) {
        this.rowList = rowList;
    }
}
