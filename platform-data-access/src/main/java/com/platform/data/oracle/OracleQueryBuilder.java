package com.platform.data.oracle;

import com.platform.data.builder.BaseQueryBuilder;
import com.platform.data.entity.Condition;

public class OracleQueryBuilder extends BaseQueryBuilder {

    @Override
    public String buildQuery(Condition condition) {
        // 过滤条件
        String filter = filter(condition.getQueryList());
        // where name like ???
        filter = filter == null || filter.isEmpty() ? "" : " where " + filter;
        // 是否启动分页查询
        if (condition.isEnablePage()) { // 分页查询
            // 判断排序条件
            if (condition.getSortList().size() > 0) { // 有排序
                // select * from (select rownum r, tb.* from (select * from user_info order by create_time desc) tb) where r > 0 and r <= 10
                // 排序条件
                String sort = sort(condition.getSortList());
                return new StringBuffer("select * from (select rownum r, tb.* from (select * from ??? ")
                        .append(filter)
                        .append(" order by ")
                        .append(sort == null || "".equals(sort) ? "" : sort)
                        .append(") tb) where r > 0 and r <= 10")
                        .toString();
            } else { // 无排序
                // select * from (select rownum r, tb.* from user_info tb) where r > 0 and r <= 10
                return new StringBuffer("select * from (select rownum r, tb.* from ??? tb")
                        .append(filter)
                        .append(") where r > ? and r <= ?").toString();
            }
        }
        // 返回结果
        return super.buildQuery(condition);
    }

}
