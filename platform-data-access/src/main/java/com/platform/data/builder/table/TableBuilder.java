package com.platform.data.builder.table;

import com.platform.data.builder.column.ColumnBuilder;
import com.platform.data.model.TableMeta;

import java.util.List;

/**
 * 表建造者
 */
public class TableBuilder {

    private TableMeta tableMeta = new TableMeta();

    /**
     * set table name
     * @param tableName
     * @return this
     */
    public TableBuilder tableName(String tableName) {
        tableMeta.setTableName(tableName);
        return this;
    }

    /**
     * add colum
     * @param columnBuilder column info
     * @return
     */
    public TableBuilder addColumn(ColumnBuilder columnBuilder) {
        tableMeta.getColumnMetaList().add(columnBuilder.build());
        return this;
    }

    /**
     * add colum
     * @param columnBuilderList column info list
     * @return
     */
    public TableBuilder addColumn(List<ColumnBuilder> columnBuilderList) {
        columnBuilderList.forEach(columnBuilder -> tableMeta.getColumnMetaList().add(columnBuilder.build()));
        return this;
    }

    /**
     * add colum
     * @param columnBuilders column info list
     * @return
     */
    public TableBuilder addColumn(ColumnBuilder... columnBuilders) {
        for (ColumnBuilder columnBuilder : columnBuilders) {
            tableMeta.getColumnMetaList().add(columnBuilder.build());
        }
        return this;
    }

    public TableMeta build() {
        return tableMeta;
    }

}
