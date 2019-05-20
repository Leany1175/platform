package com.platform.data.base;

import com.platform.data.ITable;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.entity.Condition;
import com.platform.data.entity.ConditionBean;
import com.platform.data.entity.Row;
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
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class BaseTable implements ITable {

    private static Logger logger = LoggerFactory.getLogger(BaseTable.class);
    /** 数据源 */
    protected DataSource dataSource;
    /** 表名 */
    protected final String TABLE_NAME;

    public BaseTable(DataSource dataSource, String tableName) {
        this.dataSource = dataSource;
        this.TABLE_NAME = tableName;
    }

    /**
     * 生成列建造者
     * @return 列建造者
     */
    protected abstract IColumnBuilder createBuilder();

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public void addColumn(ColumnBuilders columnBuilders) throws SQLException {
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" add column ")
                .append(columnBuilders.build(createBuilder()));

        logger.debug("新增列,SQL:{}", buffer.toString());
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public void modifyColumn(ColumnBuilders columnBuilders) throws SQLException{
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" modify ")
                .append(columnBuilders.build(createBuilder()));
        logger.debug("更新列:{}", buffer);
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public void renameColumn(String columnName, ColumnBuilders columnBuilders) throws SQLException{
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" rename column ")
                .append(columnName)
                .append(" to ")
                .append(columnBuilders.build().getColumnName());
        logger.debug("更改列名:{}", buffer.toString());
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public void dropColumn(String columnName) throws SQLException {
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append("  drop column ")
                .append(columnName);
        logger.debug("删除列:{}", buffer);
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public ISearchResult query(QueryBuilder queryBuilder) throws SQLException {
        // 条件
        Condition condition = queryBuilder.build();
        List<ConditionBean> queryList = condition.getQueryList();
        List<String> list = new ArrayList<>(queryList.size());

        List<Object> values = new ArrayList<>();
        queryList.forEach(bean -> {
            list.add(analysisCondition(bean));
            if (bean.getValue1() != null) {
                values.add(bean.getValue1());
                if (bean.getValue2() != null) {
                    values.add(bean.getValue2());
                }
            }
        });
        // 过滤条件
        String filter = String.join(" and ", list);
        StringBuffer sql = new StringBuffer("select * from ")
                .append(TABLE_NAME);
        if (filter != null && !"".equals(filter)) {
            sql.append(" where ").append(filter);
        }
        // TODO 缺少  分页、排序、聚合等
        System.out.println(sql);
        logger.debug("query sql:{}", sql);
        // TODO prepare ?
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql.toString());
            // ? set value
            for (int i = 0, len = values.size(); i < len; i++) {
                ps.setObject(i + 1, values.get(i));
            }
            // 查询
            rs = ps.executeQuery();
            while (rs.next()) {
                // TODO 结果
                System.out.println(rs);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            JdbcUtils.close(conn, ps, rs);
        }

        return null;
    }

    @Override
    public int insert(Row row) throws SQLException {
        // sql语句
        String sql = insertSql(row);
        logger.debug("insert sql:{}", sql);

        Connection conn = null;
        PreparedStatement ps = null;
        // 受影响行数
        int count = 0;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql.toString());
            // 设值
            prepareValue(ps, row);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("insert failed", e);
            throw e;
        } finally {
            JdbcUtils.close(ps);
            JdbcUtils.close(conn);
        }
        return count;
    }

    @Override
    public int[] insert(List<Row> rows) throws SQLException{
        if (rows == null || rows.size() == 0) {
            throw new NullPointerException("至少插入一行");
        }
        String sql = insertSql(rows.get(0));
        logger.debug("批量插入SQL语句:{}", sql);

        Connection conn = null;
        PreparedStatement ps = null;
        int[] count = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            for (Row row : rows) {
                prepareValue(ps, row);
                ps.addBatch();
            }
            // 批量执行
            count = ps.executeBatch();
            // 事务提交
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            conn.rollback();
            logger.error("批量插入失败,回滚", e);
            throw e;
        } finally {
            JdbcUtils.close(ps);
            JdbcUtils.close(conn);
        }
        return count;
    }

    /**
     * 插入SQL语句,value部分用"?"代替
     * @param row 行
     * @return SQL语句
     */
    protected String insertSql(Row row) {
        if (row == null || row.size() == 0) {
            throw new NullPointerException("插入的行至少一列");
        }
        // 列
        StringBuffer keys = new StringBuffer();
        // 值, 用"?"替代
        StringBuffer values = new StringBuffer();
        row.forEach((key, value) -> {
            keys.append(" ,").append(key);
            values.append(" ,").append("?");
        });
        // 拼接sql语句
        StringBuffer sql = new StringBuffer("insert into ")
                .append(TABLE_NAME)
                .append("(")
                .append(keys.delete(0, 2))
                .append(") values(")
                .append(values.delete(0, 2))
                .append(")");
        return sql.toString();
    }

    /**
     * 预编译设值
     * @param ps 与编译
     * @param row 行
     * @exception SQLException 失败
     */
    protected void prepareValue(PreparedStatement ps, Row row) throws SQLException{
        // 下标,从1开始
        int i = 1;
        for (Map.Entry<String, Object> entry : row.entrySet()) {
            ps.setObject(i, entry.getValue());
            i++;
        }
    }

    /**
     * 条件解析
     * @param condition 条件
     * @return sql "?" 代替值
     */
    protected String analysisCondition(ConditionBean condition) {
        switch (condition.getType()) {
            case  ConditionBean.TYPE_LIKE:
                return condition.getKey() + " like ?";
            default:
                throw new NullPointerException("未知过滤条件");
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
