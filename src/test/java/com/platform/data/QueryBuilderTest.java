package com.platform.data;

import com.platform.data.builder.QueryBuilder;
import com.platform.data.builder.QueryBuilders;
import org.junit.Test;

public class QueryBuilderTest {

    @Test
    public void buildTest() {

        QueryBuilder queryBuilder = QueryBuilders.mysql().tableName("user_info").field("user_id", "user_name")
//                .equals("user_name", "张")
//                .equals("sex", 0)
//                .notEquals("user_name", "name")
//                .notEquals("user_name", 66.6)
//                .startWith("name", "张三")
//                .like("name", "小六")
//                .between("birth_day", new Date(), new Date())
                .between("sex", 10, 28)
                .in("age", 10, 11, 12, 18)
                .in("name", "张三", "李四")
                .desc("age")
                .asc("id")
                .enablePage(false)
                .desc("create_time");
            System.out.println(queryBuilder.build());
    }

}
