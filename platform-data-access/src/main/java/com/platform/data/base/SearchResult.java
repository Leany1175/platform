package com.platform.data.base;

import com.platform.data.entity.ColumnConstruction;
import com.platform.data.entity.Row;
import com.platform.data.query.ISearchResult;

import java.util.List;

public class SearchResult implements ISearchResult {

    /** 表名 */
    private String tableName;
    /** 列信息 */
    private List<ColumnConstruction> schema;
    /** 行 */
    private List<Row> rows;


    @Override
    public String tableName() {
        return null;
    }

    @Override
    public List<ColumnConstruction> getSchema() {
        return null;
    }

    @Override
    public List<Row> getRows() {
        return null;
    }

    @Override
    public Object getAggregate() {
        return null;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setSchema(List<ColumnConstruction> schema) {
        this.schema = schema;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}
