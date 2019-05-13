package com.platform.data.builder;

import com.alibaba.fastjson.JSON;
import com.platform.data.entity.Column;
import com.platform.data.entity.TableConstruction;

import java.util.ArrayList;
import java.util.List;

public class TableBuilders {

    /** 表结构 */
    private TableConstruction table;

    /**
     * 设置表名
     * @param tableName 表名
     * @return this
     */
    public TableBuilders tableName(String tableName) {
        table.setTableName(tableName);
        return this;
    }


    public TableBuilders addColumn() {
        return this;
    }

    /**
     * @return 表结构
     */
    public TableConstruction build() {
        return table;
    }

    public String buildSql(ITableBuilder tableBuilder) {
        return tableBuilder.build(table);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
