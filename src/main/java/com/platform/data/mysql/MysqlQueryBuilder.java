package com.platform.data.mysql;

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
        return buffer.toString();
    }

}
