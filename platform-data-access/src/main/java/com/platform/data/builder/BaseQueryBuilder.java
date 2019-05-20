package com.platform.data.builder;

import com.platform.data.entity.Condition;
import com.platform.data.entity.ConditionBean;
import com.platform.data.query.IQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseQueryBuilder implements IQueryBuilder {

    @Override
    public String buildQuery(Condition condition) {
        StringBuffer buffer = new StringBuffer("select * from ???");

        List<ConditionBean> queryList = condition.getQueryList();
        List<String> list = new ArrayList<>(queryList.size());
        queryList.forEach(bean -> list.add(analysisCondition(bean)));

        // 过滤条件
        String filter = String.join(" and ", list);
        if (filter != null && !"".equals(filter)) {
            buffer.append(" where ").append(filter);
        }
        // TODO 分页

        return buffer.toString();
    }

    @Override
    public String buildAggregate(Condition condition) {
        return null;
    }


    /**
     * 条件解析
     * @param condition 条件
     * @return sql "?" 代替值
     */
    protected String analysisCondition(ConditionBean condition) {
        switch (condition.getType()) {
            case  ConditionBean.TYPE_LIKE:
                return condition.getKey() + " like ?";
            default:
                throw new NullPointerException("未知过滤条件");
        }
    }

}

