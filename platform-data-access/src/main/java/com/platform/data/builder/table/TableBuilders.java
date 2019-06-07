package com.platform.data.builder.table;

import com.alibaba.fastjson.JSON;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.entity.TableConstruction;

@Deprecated
public class TableBuilders {

    /** 表结构 */
    private TableConstruction table = new TableConstruction();

    /**
     * 设置表名
     * @param tableName 表名
     * @return this
     */
    public TableBuilders tableName(String tableName) {
        table.setTableName(tableName);
        return this;
    }

    /**
     * 添加列
     * @param columnBuilders 列建造者
     * @return this
     */
    public TableBuilders addColumn(ColumnBuilders columnBuilders) {
        table.getColumnList().add(columnBuilders.build());
        return this;
    }

    /**
     * 添加列
     * @param columnBuilders 列建造者
     * @return this
     */
    public TableBuilders addColumn(ColumnBuilders... columnBuilders) {
        for (ColumnBuilders builders : columnBuilders) {
            addColumn(builders);
        }
        return this;
    }

    /**
     * @return 表结构
     */
    public TableConstruction build() {
        return table;
    }

//    /**
//     * 构建
//     * @param tableBuilder 表建造者
//     * @return SQL语句
//     */
//    public String buildSql(ITableBuilder tableBuilder) {
//        return buildSql(tableBuilder, false);
//    }

//    /**
//     * 构建
//     * @param tableBuilder 表建造者
//     * @param format 是否格式化
//     * @return SQL语句
//     */
//    public String buildSql(ITableBuilder tableBuilder, boolean format) {
//        return tableBuilder.build(table, format);
//    }

    /**
     * TODO 重写toString()
     * @return
     */
    @Override
    public String toString() {
        return JSON.toJSONString(table);
    }
}
