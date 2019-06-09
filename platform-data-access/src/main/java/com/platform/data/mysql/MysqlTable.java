package com.platform.data.mysql;

import com.alibaba.fastjson.JSON;
import com.platform.data.base.SearchResult;
import com.platform.data.builder.column.ColumnBuilder;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.base.BaseTable;
import com.platform.data.entity.ColumnConstruction;
import com.platform.data.entity.Condition;
import com.platform.data.entity.ConditionBean;
import com.platform.data.query.IQueryBuilder;
import com.platform.data.query.ISearchResult;
import com.platform.data.query.QueryBuilder;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlTable extends BaseTable {

    private static Logger logger = LoggerFactory.getLogger(MysqlTable.class);

    public MysqlTable(DataSource dataSource, String tableName) {
        super(dataSource, tableName);
    }

    @Override
    protected IColumnBuilder createColumnBuilder() {
        return new MysqlColumnBuilder();
    }

    @Override
    protected IColumnBuilder createBuilder() {
        return new MysqlColumnBuilder();
    }

    @Override
    protected IQueryBuilder createQueryBuild() {
        return new MysqlQueryBuilder();
    }

    @Override
    public void renameColumn(String columnName, ColumnBuilder columnBuilder) throws SQLException {
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" change column ")
                .append(columnName)
                .append(" ")
                .append(createColumnBuilder().build(columnBuilder.build()));
        logger.debug("rename column:{}", buffer);
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    /**
     * 预编译设值
     * @param ps 与编译
     * @param condition 条件
     * @exception SQLException 失败
     */
    protected void prepareValue(PreparedStatement ps, Condition condition) throws SQLException{
        // 查询条件
        List<ConditionBean> conditionList = condition.getQueryList();

        List<Object> values = new ArrayList<>();
        // 查询条件
        conditionList.forEach(bean -> {
            if (bean.getValue1() != null) {
                values.add(bean.getValue1());
            }
            if (bean.getValue2() != null) {
                values.add(bean.getValue2());
            }
        });

        // ? set value
        for (int i = 0, len = values.size(); i < len; i++) {
            ps.setObject(i + 1, values.get(i));
        }

    }

}
