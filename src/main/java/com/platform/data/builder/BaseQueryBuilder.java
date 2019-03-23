package com.platform.data.builder;

import com.platform.data.QueryCondition;
import com.platform.utils.date.DateUtils;

import java.text.ParseException;
import java.util.*;

public abstract class BaseQueryBuilder implements QueryBuilder{

//	/** 是否分页 */
//	protected boolean isPage = true;
//    /** 表名 */
//    protected String tableName;
//    /** 查询字段 */
//    protected List<String> fieldList = new LinkedList<>();
//    /** 当前页,默认为1 */
//    protected int pageNo = 1;
//    /** 条数,默认为10 */
//    protected int size = 10;
//    /** 查询条件 */
//    protected List<ConditionBean> conditionList = new LinkedList<>();
//    /** 排序条件 */
//    protected List<ConditionBean> orderList = new LinkedList<>();

	protected QueryCondition condition = new QueryCondition();

    @Override
    public QueryBuilder tableName(String name) {
		condition.setTableName(name);
        return this;
    }

//    @Override
//    public QueryBuilder field(String field) {
//		condition.getFieldList().add(field);
//        fieldList.add(field);
//
//        return this;
//    }

    @Override
    public QueryBuilder field(String... fields) {
		condition.getFieldList().addAll(Arrays.asList(fields));
        return this;
    }

    @Override
    public QueryBuilder field(List<String> fields) {
        condition.getFieldList().addAll(fields);
        return this;
    }

    @Override
	public QueryBuilder currentPage(int currentPage) {
	    if (currentPage <= 0) {
	        throw new IllegalArgumentException("currentPage值不能小于等于0");
        }
	    condition.setPageNo(currentPage);
		return this;
	}

	@Override
	public QueryBuilder size(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("每页展示条数不能小于等于0");
        }
        condition.setSize(size);
		return this;
	}

	@Override
	public QueryBuilder equals(String field, String str) {
	    condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_EQUALS, "'" + str + "'"));
		return this;
	}

    @Override
    public QueryBuilder equals(String field, Number number) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_EQUALS, number));
        return this;
    }

    @Override
    public QueryBuilder notEquals(String field, String str) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_NOT_EQUALS, "'" + str + "'"));
        return this;
    }

	@Override
	public QueryBuilder notEquals(String field, Number number) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_NOT_EQUALS, number));
        return this;
	}

	@Override
	public QueryBuilder startWith(String field, String str) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_START_WITH, "'" + str + "%'"));
        return this;
	}

	@Override
	public QueryBuilder like(String field, String str) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_LIKE, "'%" + str + "%'"));
        return this;
	}

	@Override
	public QueryBuilder between(String field, Number min, Number max) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_BETWEEN, min, max));
        return this;
	}

	@Override
	public QueryBuilder between(String field, Date start, Date end) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_BETWEEN, start, end));
        return this;
	}

	@Override
	public QueryBuilder gt(String field, Number number) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_GT, number));
        return this;
	}

	@Override
	public QueryBuilder gte(String field, Number number) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_GTE, number));
        return this;
	}

	@Override
	public QueryBuilder lt(String field, Number number) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_LT, number));
        return this;
	}

	@Override
	public QueryBuilder lte(String field, Number number) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_LTE, number));
        return this;
	}

    @Override
    public QueryBuilder in(String field, String... strs) {
    	if (strs.length == 0) {
    		throw new NullPointerException("必须给定字符串数组");
		}
    	List<String> list = new ArrayList<>(Arrays.asList(strs));
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_IN, list));
        return this;
    }

    @Override
    public QueryBuilder in(String field, Number... numbers) {
		if (numbers.length == 0) {
			throw new NullPointerException("必须给定数字数组");
		}
		List<Number> list = new LinkedList<>(Arrays.asList(numbers));
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_IN, list));
        return this;
    }

    @Override
	public QueryBuilder isNull(String field) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_IS_NULL));
        return this;
	}

	@Override
	public QueryBuilder isNotNull(String field) {
		condition.getConditionList().add(new ConditionBean(field, ConditionBean.TYPE_IS_NOT_NULL));
        return this;
	}

	@Override
	public QueryBuilder desc(String field) {
		condition.getOrderList().add(new ConditionBean(field, ConditionBean.TYPE_DESC));
        return this;
	}

	@Override
	public QueryBuilder asc(String field) {
		condition.getOrderList().add(new ConditionBean(field, ConditionBean.TYPE_ASC));
        return this;
	}

	@Override
	public QueryBuilder enablePage(boolean isPage) {
    	condition.setPage(isPage);
		return this;
	}

	@Override
	public QueryCondition getQueryCondition() {
		return condition;
	}

//	@Override
//	public String getTableName() {
//		return tableName;
//	}

//	@Override
//    public List<ConditionBean> getQueryCondition() {
//        return conditionList;
//    }
//
////    @Override
//    public List<ConditionBean> getOrderCondition() {
//        return orderList;
//    }

	/**
	 * 生成查询sql语句
	 * @param condition 条件
	 * @return sql语句,如: name like '%zhang%'
	 * @exception ParseException 时间转换异常
	 */
	protected String createQueryCondition(ConditionBean condition) {
		switch (condition.getType()) {
			case ConditionBean.TYPE_EQUALS:
				return condition.getKey() + " = " + condition.getValue1();
			case ConditionBean.TYPE_NOT_EQUALS:
				return condition.getKey() + " != " + condition.getValue1();
			case ConditionBean.TYPE_START_WITH:
				return condition.getKey() + " like " + condition.getValue1();
			case ConditionBean.TYPE_LIKE:
				return condition.getKey() + " like " + condition.getValue1();
			case ConditionBean.TYPE_BETWEEN:
				// 时间
				if (condition.getValue1() instanceof Date) {
					return condition.getKey() + " between '" + DateUtils.formatTime((Date) condition.getValue1())
							+ "' and '" + DateUtils.formatTime((Date) condition.getValue2()) + "'";
				} else {
					return condition.getKey() + " between " + condition.getValue1() + " and " + condition.getValue2();
				}
			case ConditionBean.TYPE_GT:
				return condition.getKey() + " > " + condition.getValue1();
			case ConditionBean.TYPE_GTE:
				return condition.getKey() + " >= " + condition.getValue1();
			case ConditionBean.TYPE_LT:
				return condition.getKey() + " < " + condition.getValue1();
			case ConditionBean.TYPE_LTE:
				return condition.getKey() + " <= " + condition.getValue1();
			case ConditionBean.TYPE_IS_NULL:
				return condition.getKey() + " is null";
			case ConditionBean.TYPE_IS_NOT_NULL:
				return condition.getKey() + " is not null";
			case ConditionBean.TYPE_IN:
				List<?> list = (List<?>) condition.getValue1();
				StringBuffer buffer = new StringBuffer();
				list.forEach(obj -> {
					buffer.append(obj instanceof String ? "'" + obj + "'" : obj)
							.append(",");
				});
				// 删除最后一个 ","
				buffer.delete(buffer.length() - 1, buffer.length());
				return condition.getKey() + " in(" + buffer.toString() + ")";
			default:
				break;
		}
    	return null;
	}

	/**
	 * 生成查询sql语句
	 * @param condition 条件
	 * @return sql语句,如: name like '%zhang%'
	 */
	protected String createOrderCondition(ConditionBean condition) {
		switch (condition.getType()) {
			case ConditionBean.TYPE_ASC:
				return condition.getKey() + " desc";
			case ConditionBean.TYPE_DESC:
				return condition.getKey() + " asc";
			default:
				break;
		}
		return null;
	}

}
