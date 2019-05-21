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

        // 过滤条件
        String filter = filter(condition.getQueryList());
        if (filter != null && !"".equals(filter)) {
            buffer.append(" where ").append(filter);
        }
        return buffer.append(condition.isEnablePage() ? " limit ?, ?" : "").toString();
    }

    @Override
    public String buildAggregate(Condition condition) {
        return null;
    }

    /**
     * 过滤条件
     * @param queryList 条件
     */
    protected String filter(List<ConditionBean> queryList) {
        List<String> list = new ArrayList<>(queryList.size());
        queryList.forEach(bean -> list.add(analyseQuery(bean)));

        // 过滤条件
        return String.join(" and ", list);
    }

    /**
     * 排序条件
     * @param sortList 排序
     * @return 排序条件
     */
    protected String sort(List<ConditionBean> sortList) {
        List<String> list = new ArrayList<>(sortList.size());
        sortList.forEach(bean -> list.add(analyseQuery(bean)));

        // 过滤条件
        return String.join(", ", list);
    }

    /**
     * 条件解析
     * @param condition 条件
     * @return sql "?" 代替值
     */
    protected String analyseQuery(ConditionBean condition) {
        switch (condition.getType()) {
            case  ConditionBean.TYPE_LIKE:
                return condition.getKey() + " like ?";
            default:
                throw new NullPointerException("未知过滤条件");
        }
    }

    /**
     * 排序解析
     * @param condition 条件
     * @return 排序条件
     */
    protected String analyseSort(ConditionBean condition) {
        switch (condition.getType()) {
            case ConditionBean.TYPE_DESC:
                return condition.getKey() + " desc";
            case ConditionBean.TYPE_ASC:
                return condition.getKey() + " asc";
            default:
                throw new NullPointerException("未知排序条件");
        }
    }

}

