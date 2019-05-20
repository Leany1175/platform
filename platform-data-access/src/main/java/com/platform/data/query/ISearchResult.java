package com.platform.data.query;

import com.platform.data.IMetaData;

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
    IMetaData getMetaData();

    // TODO 获取所有行

    // TODO 聚合统计结果

}
