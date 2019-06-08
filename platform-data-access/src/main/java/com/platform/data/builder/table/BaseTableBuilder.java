package com.platform.data.builder.table;

import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.model.ColumnMeta;
import com.platform.data.model.TableMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTableBuilder implements ITableBuilder {

    /** column build */
    protected IColumnBuilder columnBuilder;

    @Override
    public String build(TableBuilder tableBuilder, boolean format) {
        TableMeta tableMeta = tableBuilder.build();
        StringBuffer buffer = new StringBuffer("create table ")
                .append(tableMeta.getTableName())
                .append(" (?)");

        // sql
        String sql = buffer.toString();

        List<ColumnMeta> columnMetaList = tableMeta.getColumnMetaList();
        List<String> columnList = new ArrayList<>(columnMetaList.size());
        columnMetaList.forEach(columnMeta -> columnList.add(columnBuilder.build(columnMeta)));

        if (format) {
            return sql.replaceAll("\\?", "\n\t\t" + String.join(",\n\t\t", columnList) + "\n");
        }
        return sql.replaceAll("\\?", String.join(",", columnList));
    }

}
