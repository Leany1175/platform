package com.platform.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询 聚合条件
 */
public class Condition implements Serializable {

    /** 开始条数 */
    private int from = 0;
    /** 展示条数 */
    private int size = 20;
    /** 默认使用分页查询 */
    private boolean enablePage = true;
    /** 排序条件 */
    private List<ConditionBean> sortList = new ArrayList<>();
    /** 查询条件 */
    private List<ConditionBean> queryList = new ArrayList<>();
    /** TODO 聚合条件 */
    private Map<String, Object> aggMap = new HashMap<>();

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<ConditionBean> getSortList() {
        return sortList;
    }

    public boolean isEnablePage() {
        return enablePage;
    }

    public void setEnablePage(boolean enablePage) {
        this.enablePage = enablePage;
    }

    public void setSortList(List<ConditionBean> sortList) {
        this.sortList = sortList;
    }

    public List<ConditionBean> getQueryList() {
        return queryList;
    }

    public void setQueryList(List<ConditionBean> queryList) {
        this.queryList = queryList;
    }

    public Map<String, Object> getAggMap() {
        return aggMap;
    }

    public void setAggMap(Map<String, Object> aggMap) {
        this.aggMap = aggMap;
    }
}
