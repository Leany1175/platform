package com.platform.data.query;

import com.platform.data.entity.Row;
import com.platform.data.entity.TableConstruction;

import java.util.List;

public interface ISearchResult {

    /**
     * 表结构
     * @return 表结构
     */
    TableConstruction getSchema();

    // TODO 获取所有行
    List<Row> getRows();

}
