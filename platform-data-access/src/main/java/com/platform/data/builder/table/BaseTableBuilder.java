package com.platform.data.builder.table;

import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.entity.ColumnConstruction;
import com.platform.data.entity.TableConstruction;
import com.platform.data.model.ColumnMeta;
import com.platform.data.model.TableMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTableBuilder implements ITableBuilder {

    /** 构建列 */
//    @Deprecated
//    protected abstract String buildColumn(ColumnConstruction column);

//    @Deprecated
//    protected abstract String buildColumn(ColumnMeta columnMeta);
    /** column build */
    protected IColumnBuilder columnBuilder;

//    public BaseTableBuilder(IColumnBuilder columnBuilder) {
//        this.columnBuilder = columnBuilder;
//    }

    //    @Override
//    public String build(TableConstruction construction, boolean format) {
//        StringBuffer buffer = new StringBuffer("create table ")
//                .append(construction.getTableName())
//                .append(" (?)");
//        // sql语句
//        String sql = buffer.toString();
//        // 列 sql集合
//        List<String> columnList = createColumn(construction.getColumnList());
//        if (format) {
//            return sql.replaceAll("\\?", "\n\t\t" + String.join(",\n\t\t", columnList) + "\n");
//        }
//        return sql.replaceAll("\\?", String.join(",", columnList));
//    }

    @Override
    public String build(TableBuilder tableBuilder, boolean format) {
//        TableMeta tableMeta = tableBuilder.build();
//        StringBuffer buffer = new StringBuffer("create table ")
//                .append(tableMeta.getTableName())
//                .append(" (?)");
//        // sql语句
//        String sql = buffer.toString();
//        // 列 sql集合
//        List<String> columnList = createColumn(tableMeta.getColumnMetaList());
//        if (format) {
//            return sql.replaceAll("\\?", "\n\t\t" + String.join(",\n\t\t", columnList) + "\n");
//        }
//        return sql.replaceAll("\\?", String.join(",", columnList));


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

//    /**
//     * 列sql集合
//     * @param columnList 列信息
//     * @return sql
//     */
//    @Deprecated
//    protected List<String> createColumn(List<ColumnConstruction> columnList) {
//        List<String> list = new ArrayList<>(columnList.size());
//        for (ColumnConstruction column : columnList) {
//            list.add(buildColumn(column));
//        }
//        return list;
//    }

//    protected List<String> createColumn(List<ColumnMeta> columnMetaList) {
//        List<String> list = new ArrayList<>(columnMetaList.size());
//        for (ColumnMeta columnMeta : columnMetaList) {
//            list.add(buildColumn(columnMeta));
//        }
//        return list;
//    }

}
