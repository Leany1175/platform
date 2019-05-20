package com.platform.data.query;

import com.platform.data.entity.Condition;
import com.platform.data.entity.ConditionBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryBuilder {

    /** 条件 */
    private Condition condition = new Condition();

    /**
     * 升序排列
     * @param field 字段
     * @return this
     */
    public QueryBuilder asc(String field) {
        condition.getSortList().add(new ConditionBean(ConditionBean.TYPE_ASC, field));
        return this;
    }

    /**
     * 降序排列
     * @param field 字段
     * @return this
     */
    public QueryBuilder desc(String field) {
        condition.getSortList().add(new ConditionBean(ConditionBean.TYPE_DESC, field));
        return this;
    }

    /**
     * 字符串等于
     * @param field 字段
     * @param value 值
     * @return this
     */
    public QueryBuilder equals(String field, String value) {
        condition.getQueryList().add(new ConditionBean(ConditionBean.TYPE_EQUALS, field, "'" + value + "'"));
        return this;
    }

    /**
     * 数字等于
     * @param field 字段
     * @param value 值
     * @return this
     */
    public QueryBuilder equals(String field, Number value) {
        condition.getQueryList().add(new ConditionBean(ConditionBean.TYPE_EQUALS, field, value));
        return this;
    }

    /**
     * 字符串不等于
     * @param field 字段
     * @param value 值
     * @return this
     */
    public QueryBuilder notEquals(String field, String value) {
        condition.getQueryList().add(new ConditionBean(ConditionBean.TYPE_NOT_EQUALS, field, "'" + value + "'"));
        return this;
    }

    /**
     * 数字不等于
     * @param field 字段
     * @param value 值
     * @return this
     */
    public QueryBuilder notEquals(String field, Number value) {
        condition.getQueryList().add(new ConditionBean(ConditionBean.TYPE_NOT_EQUALS, field, value));
        return this;
    }

    /**
     * 以???开始
     * @param field 字段
     * @param value 值
     * @return this
     */
    public QueryBuilder startWith(String field, String value) {
        condition.getQueryList().add(new ConditionBean(ConditionBean.TYPE_START_WITH, field, "'" + value + "%'"));
        return this;
    }

    /**
     * 模糊查询
     * @param field 字段
     * @param value 值
     * @return this
     */
    public QueryBuilder like(String field, String value) {
        condition.getQueryList().add(new ConditionBean(ConditionBean.TYPE_LIKE, field, "%" + value + "%"));
        return this;
    }

    @Deprecated
    public String build(IQueryBuilder queryBuilder) {
        return null;
    }

    /**
     * 条件
     * @return 条件
     */
    public Condition build() {
        return condition;
    }

}
