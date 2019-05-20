package com.platform.data.base;

import com.platform.data.entity.ColumnConstruction;
import com.platform.data.entity.Row;
import com.platform.data.query.ISearchResult;

import java.util.List;

public class SearchResult implements ISearchResult {

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

}
