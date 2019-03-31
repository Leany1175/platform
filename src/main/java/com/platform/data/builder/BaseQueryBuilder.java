package com.platform.data.builder;

import com.platform.data.WhereClauseImpl;
import com.platform.utils.date.DateUtils;

import java.text.ParseException;
import java.util.*;

public abstract class BaseQueryBuilder extends WhereClauseImpl implements IQueryBuilder{

//	protected QueryCondition condition = new QueryCondition();
	/** 是否分页 */
	protected boolean isPage = true;
	/** 表名 */
	protected String tableName;
	/** 查询字段 */
	protected List<String> fieldList = new LinkedList<>();
	/** 当前页,默认为1 */
	protected int pageNo = 1;
	/** 条数,默认为10 */
	protected int size = 10;

    @Override
    public IQueryBuilder tableName(String name) {
		this.tableName = name;
        return this;
    }

    @Override
    public IQueryBuilder field(String... fields) {
		this.fieldList.addAll(Arrays.asList(fields));
        return this;
    }

    @Override
    public IQueryBuilder field(Collection<String> fields) {
		this.fieldList.addAll(fields);
        return this;
    }

    @Override
	public IQueryBuilder currentPage(int currentPage) {
	    if (currentPage <= 0) {
	        throw new IllegalArgumentException("currentPage值不能小于等于0");
        }
	    this.pageNo = currentPage;
		return this;
	}

	@Override
	public IQueryBuilder size(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("每页展示条数不能小于等于0");
        }
        this.size = size;
		return this;
	}

	@Override
	public IQueryBuilder enablePage(boolean isPage) {
    	this.isPage = isPage;
		return this;
	}

//	@Override
//	public String buildWhereClause() {
//		return null;
//	}

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
