package com.platform.data;

import com.platform.data.builder.ConditionBean;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class WhereClauseImpl implements IWhereClause{

	/** 查询条件 */
	protected List<ConditionBean> conditionList = new LinkedList<>();
	/** 排序条件 */
	protected List<ConditionBean> orderList = new LinkedList<>();

	@Override
	public IWhereClause equals(String field, String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause equals(String field, Number number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause notEquals(String field, String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause notEquals(String field, Number number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause startWith(String field, String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause like(String field, String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause between(String field, Number min, Number max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause between(String field, Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause gt(String field, Number number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause gte(String field, Number number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause lt(String field, Number number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause lte(String field, Number number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause in(String field, Number... numbers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause in(String field, String... strs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause isNull(String field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause isNotNull(String field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause desc(String field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWhereClause asc(String field) {
		// TODO Auto-generated method stub
		return null;
	}

}
