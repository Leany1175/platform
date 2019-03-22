package com.platform.data.mysql;

import java.util.ArrayList;
import java.util.List;

import com.platform.data.builder.BaseQueryBuilder;

public class MysqlQueryBuilder extends BaseQueryBuilder {

    @Override
    public String build() {
        StringBuffer buffer = new StringBuffer("select");
        if (fieldList.size() > 0) {
            buffer.append(" " + String.join(",", fieldList));
        } else {
            buffer.append(" *");
        }
        buffer.append(" from ")
                .append(tableName)
                .append(" where 1 = 1");

        // and
        conditionList.forEach(condition -> buffer.append(" and ")
                .append(createQueryCondition(condition)));

        if (orderList.size() > 0) {
            buffer.append(" order by ");
            List<String> list = new ArrayList<>();
            orderList.forEach(condition -> list.add(createOrderCondition(condition)));
            buffer.append(String.join(",", list));
        }
        // 分页
        if (isPage) {
            buffer.append(" limit " + (pageNo - 1) * size + ",")
                    .append(size);
        }
        return buffer.toString();
    }

}
