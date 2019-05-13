package com.platform.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 表结构
 */
public class TableConstruction implements Serializable {

    /** 表名 */
    private String tableName;
    /** 列 集合 */
    private List<ColumnConstruction> columnList = new ArrayList<>();


    public List<ColumnConstruction> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnConstruction> columnList) {
        this.columnList = columnList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
