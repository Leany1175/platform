package com.platform.data.builder;

import com.platform.data.mysql.MysqlQueryBuilder;

@Deprecated
public class QueryBuilders {

    private QueryBuilders() {}

    public static IQueryBuilder mysql() {
        return new MysqlQueryBuilder();
    }

}
