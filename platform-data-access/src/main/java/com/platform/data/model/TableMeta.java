package com.platform.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TableMeta implements Serializable {

    /** table name */
    private String tableName;
    /** colum list */
    private List<ColumnMeta> columnMetaList = new ArrayList<>();

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
}
