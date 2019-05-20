package com.platform.data.query;

import com.platform.data.entity.Condition;

/**
 * 表名用"???"代替
 */
public interface IQueryBuilder {

    /**
     * 查询sql语句
     * @param condition 条件
     * @return sql
     */
    String buildQuery(Condition condition);

    /**
     * 聚合SQL语句
     * @param condition 条件
     * @return sql
     */
    String buildAggregate(Condition condition);

}
