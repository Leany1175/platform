package com.platform.data;

import com.platform.data.builder.QueryBuilder;
import com.platform.data.builder.QueryBuilders;
import org.junit.Test;

public class QueryBuilderTest {

    @Test
    public void buildTest() {
        QueryBuilder queryBuilder = QueryBuilders.mysql().tableName("user_info").field("user_id", "user_name")
                .like("user_name", "张");
        System.out.println(queryBuilder.build());
    }

}
