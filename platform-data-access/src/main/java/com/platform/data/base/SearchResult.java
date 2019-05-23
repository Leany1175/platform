package com.platform.data.base;

import com.platform.data.entity.ColumnConstruction;
import com.platform.data.entity.Row;
import com.platform.data.entity.TableConstruction;
import com.platform.data.query.ISearchResult;

import java.util.List;

public class SearchResult implements ISearchResult {

    /** 表结构 */
    private TableConstruction schema;
    /** 行 */
    private List<Row> rows;

    public void setSchema(TableConstruction schema) {
        this.schema = schema;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public TableConstruction getSchema() {
        return schema;
    }

    @Override
    public List<Row> getRows() {
        return rows;
    }
}
