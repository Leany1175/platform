package com.platform.data.builder;

import com.platform.data.entity.ColumnConstruction;
import com.platform.data.entity.TableConstruction;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTableBuilder implements ITableBuilder {

    /** 构建列 */
    protected abstract String buildColumn(ColumnConstruction column);

    @Override
    public String build(TableConstruction construction, boolean format) {
        StringBuffer buffer = new StringBuffer("create table ")
                .append(construction.getTableName())
                .append(" (?)");
        // sql语句
        String sql = buffer.toString();
        // 列 sql集合
        List<String> columnList = createColumn(construction.getColumnList());
        if (format) {
            return sql.replaceAll("\\?", "\n\t\t" + String.join(",\n\t\t", columnList) + "\n");
        }
        return sql.replaceAll("\\?", String.join(",", columnList));
    }

    /**
     * 列sql集合
     * @param columnList 列信息
     * @return sql
     */
    protected List<String> createColumn(List<ColumnConstruction> columnList) {
        List<String> list = new ArrayList<>(columnList.size());
        for (ColumnConstruction column : columnList) {
            list.add(buildColumn(column));
        }
        return list;
    }

}
