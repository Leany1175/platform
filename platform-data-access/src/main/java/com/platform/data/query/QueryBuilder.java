package com.platform.data.query;

import com.platform.data.entity.Condition;
import com.platform.data.entity.ConditionBean;

import java.util.*;

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

    /**
     * 开始
     * @param from 开始条数
     * @return this
     */
    public QueryBuilder from(int from) {
        condition.setFrom(from);
        return this;
    }

    /**
     * 条数
     * @param size 查询条数
     * @return this
     */
    public QueryBuilder size(int size) {
        condition.setSize(size);
        return this;
    }

    /**
     * 是否启用分页查询
     * @param enabled true代表分页查询
     * @return this
     */
    public QueryBuilder enablePage(boolean enabled) {
        condition.setEnablePage(enabled);
        return this;
    }

    /**
     * 构建SQL语句
     * @param queryBuilder 条件
     * @return value用?替代
     */
    public String build(IQueryBuilder queryBuilder) {
        return queryBuilder.buildQuery(condition);
    }

    /**
     * 条件
     * @return 条件
     */
    public Condition build() {
        return condition;
    }

    /**
     * 所有值 查询 + 排序
     * @return 值
     */
    public List<Object> values() {
        List<Object> list = new LinkedList<>();
        condition.getQueryList().forEach(bean -> {
            if (bean.getValue1() != null) {
                list.add(bean.getValue1());
            }
            if (bean.getValue2() != null) {
                list.add(bean.getValue2());
            }
        });
        return list;
    }

}
