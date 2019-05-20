package com.platform.data.query;

import com.platform.data.entity.ColumnConstruction;
import com.platform.data.entity.Row;

import java.util.List;
import java.util.Map;

public interface ISearchResult {

    /**
     * 返回查询表名
     * @return 表名
     */
    String tableName();

    /**
     * 列信息
     * @return 列
     */
    List<ColumnConstruction> getSchema();

    // TODO 获取所有行
    List<Row> getRows();

    // TODO 聚合统计结果
    Object getAggregate();

}
