package com.platform.data.mysql;

import com.platform.data.builder.base.BaseQueryBuilder;

public class MysqlQueryBuilder extends BaseQueryBuilder {

    @Override
    public String buildString() {
//        StringBuffer buffer = new StringBuffer("select");
//        if (condition.getFieldList().size() > 0) {
//            buffer.append(" " + String.join(",", condition.getFieldList()));
//        } else {
//            buffer.append(" *");
//        }
//        buffer.append(" from ")
//                .append(condition.getTableName());
//
//        // and查询
//        buffer.append(" where 1 = 1");
//        condition.getConditionList().forEach(cndi -> buffer.append(" and ")
//                .append(createQueryCondition(cndi)));
//
//        // 排序
//        if (condition.getOrderList().size() > 0) {
//            buffer.append(" order by ");
//            List<String> list = new ArrayList<>();
//            condition.getOrderList().forEach(cndi -> list.add(createOrderCondition(cndi)));
//            buffer.append(String.join(",", list));
//        }
//        // 分页
//        if (condition.isPage()) {
//            buffer.append(" limit " + (condition.getPageNo() - 1) * condition.getSize() + ",")
//                    .append(condition.getSize());
//        }
//        return buffer.toString();
        return null;
    }

}
