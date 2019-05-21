package com.platform.data.mysql;

import com.platform.data.builder.BaseQueryBuilder;
import com.platform.data.entity.Condition;

public class MysqlQueryBuilder extends BaseQueryBuilder {

    @Override
    public String buildQuery(Condition condition) {
        StringBuffer buffer = new StringBuffer("select * from ???");

        // 过滤
        String filter = filter(condition.getQueryList());
        buffer.append(filter == null || "".equals(filter) ? "" : " where " + filter);

        // 排序
        String sort = sort(condition.getSortList());
        buffer.append(sort == null || "".equals(sort) ? "" : " order by " + sort);

        return buffer.append(condition.isEnablePage() ? " limit " + condition.getFrom() + ", " + condition.getSize() : "").toString();
    }

}
