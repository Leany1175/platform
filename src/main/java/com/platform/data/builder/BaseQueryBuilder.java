package com.platform.data.builder;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseQueryBuilder implements QueryBuilder{

    /** 表名 */
    protected String tableName;
    /** 查询字段 */
    protected List<String> fieldList = new LinkedList<>();
    /** 当前页,默认为1 */
    protected int pageNo = 1;
    /** 条数,默认为10 */
    protected int size = 10;
    /** 查询条件 */
    protected List<ConditionBean> conditionList = new LinkedList<>();
    /** 排序条件 */
    private List<ConditionBean> orderList = new LinkedList<>();

    @Override
    public QueryBuilder tableName(String name) {
        this.tableName = name;
        return this;
    }

    @Override
    public QueryBuilder field(String field) {
        fieldList.add(field);
        return this;
    }

    @Override
    public QueryBuilder field(String... fields) {
        fieldList.addAll(Arrays.asList(fields));
        return this;
    }

    @Override
    public QueryBuilder field(List<String> fields) {
        fieldList.addAll(fields);
        return this;
    }

    @Override
	public QueryBuilder currentPage(int currentPage) {
	    if (currentPage <= 0) {
	        throw new IllegalArgumentException("currentPage值不能小于等于0");
        }
	    this.pageNo = currentPage;
		return this;
	}

	@Override
	public QueryBuilder size(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("每页展示条数不能小于等于0");
        }
        this.size = size;
		return this;
	}

	@Override
	public QueryBuilder equals(String field, String str) {
	    conditionList.add(new ConditionBean(field, ConditionBean.TYPE_EQUALS, str));
		return this;
	}

    @Override
    public QueryBuilder equals(String field, Number number) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_EQUALS, number));
        return this;
    }

    @Override
    public QueryBuilder notEquals(String field, String str) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_NOT_EQUALS, str));
        return this;
    }

	@Override
	public QueryBuilder notEquals(String field, Number number) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_NOT_EQUALS, number));
        return this;
	}

	@Override
	public QueryBuilder startWith(String field, String str) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_START_WITH, str + "%"));
        return this;
	}

	@Override
	public QueryBuilder like(String field, String str) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_LIKE, "%" + str + "%"));
        return this;
	}

	@Override
	public QueryBuilder between(String field, Number min, Number max) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_BETWEEN, min, max));
        return this;
	}

	@Override
	public QueryBuilder between(String field, Date start, Date end) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_EQUALS, start, end));
        return this;
	}

	@Override
	public QueryBuilder gt(String field, Number number) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_GT, number));
        return this;
	}

	@Override
	public QueryBuilder gte(String field, Number number) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_GTE, number));
        return this;
	}

	@Override
	public QueryBuilder lt(String field, Number number) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_LT, number));
        return this;
	}

	@Override
	public QueryBuilder lte(String field, Number number) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_LTE, number));
        return this;
	}

    @Override
    public QueryBuilder in(String field, String... strs) {
	    for (String str : strs) {
	        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_IN, str));
        }
        return this;
    }

    @Override
    public QueryBuilder in(String field, Number... numbers) {
        for (Number number : numbers) {
            conditionList.add(new ConditionBean(field, ConditionBean.TYPE_IN, number));
        }
        return this;
    }

    @Override
	public QueryBuilder isNull(String field) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_IS_NULL));
        return this;
	}

	@Override
	public QueryBuilder isNotNull(String field) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_IS_NOT_NULL));
        return this;
	}

	@Override
	public QueryBuilder desc(String field) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_DESC));
        return this;
	}

	@Override
	public QueryBuilder asc(String field) {
        conditionList.add(new ConditionBean(field, ConditionBean.TYPE_ASC));
        return this;
	}

    @Override
    public List<ConditionBean> getQueryCondition() {
        return conditionList;
    }

    @Override
    public List<ConditionBean> getOrderCondition() {
        return orderList;
    }

}
