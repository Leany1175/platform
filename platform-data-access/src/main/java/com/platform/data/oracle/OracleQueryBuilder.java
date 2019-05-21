package com.platform.data.oracle;

import com.platform.data.builder.BaseQueryBuilder;
import com.platform.data.entity.Condition;

public class OracleQueryBuilder extends BaseQueryBuilder {

    @Override
    public String buildQuery(Condition condition) {
        // 是否启动分页查询
        if (condition.isEnablePage()) { // 分页查询
            // 判断排序条件
            if (condition.getSortList().size() > 0) { // 有排序
                // select * from (select rownum r, tb.* from (select * from user_info order by create_time desc) tb) where r > 0 and r < 10
                // TODO
            } else { // 无排序
                // select * from (select rownum r, tb.* from user_info tb) where r > 0 and r < 10
                // TODO
            }
        } else { // 普通查询


        }
        // TODO return 返回结果
        return super.buildQuery(condition);
    }

}
