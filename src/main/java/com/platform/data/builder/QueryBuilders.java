package com.platform.data.builder;

import com.platform.data.mysql.MysqlQueryBuilder;

public class QueryBuilders {

    private QueryBuilders() {}

    public static QueryBuilder mysql() {
        return new MysqlQueryBuilder();
    }

}