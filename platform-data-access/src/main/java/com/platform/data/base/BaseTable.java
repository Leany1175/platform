package com.platform.data.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.platform.data.ITable;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.entity.*;
import com.platform.data.enums.ColumnTypeEnum;
import com.platform.data.other.Table;
import com.platform.data.query.IQueryBuilder;
import com.platform.data.query.ISearchResult;
import com.platform.data.query.QueryBuilder;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

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

    /**
     * 生成查询建造者
     * @return 查询
     */
    protected abstract IQueryBuilder createQueryBuild();

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
        // 查询结果

        // sql查询语句, select * from ??? where ...
        String sql = queryBuilder.build(createQueryBuild());
        sql = sql.replaceAll("\\?\\?\\?", TABLE_NAME);
        logger.debug("query sql:{}", sql);

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // 查询结果
        SearchResult result = new SearchResult();
        TableConstruction table = new TableConstruction();
        // 表名
        table.setTableName(TABLE_NAME);
        // 表信息
        result.setSchema(table);
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);

            // 预编译设值
            prepareValue(ps, queryBuilder.build());
            // 所有列
            table.setColumnList(analyzeColumn(ps));

            // 查询
            rs = ps.executeQuery();
            // 结果解析
            result.setRows(analyzeResult(rs, table.getColumnList()));
        } catch (SQLException e) {
            throw e;
        } finally {
            JdbcUtils.close(conn, ps, rs);
        }

        return result;
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
            ps = conn.prepareStatement(sql);
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

    @Override
    public int update(Row row) throws SQLException{
        if (row == null || row.size() == 0) {
            throw new NullPointerException("row must not null or empty");
        }

        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        StringBuffer update = new StringBuffer();
        row.forEach((key, value) -> update.append(", ").append(key).append(" = ?"));
        StringBuffer buffer = new StringBuffer("update ")
                .append(TABLE_NAME)
                .append(" set ")
                .append(update.delete(0, 2));

        logger.debug("update row sql:{}", buffer);

        // TODO SQL
//        try {
//            conn = dataSource.getConnection();
//            ps = conn.prepareStatement("");
//
//        } catch (SQLException e) {
//            // 回滚
//            conn.rollback();
//            logger.error("update row faild", e);
//            throw e;
//        } finally {
//            // 关闭
//            JdbcUtils.close(ps);
//            JdbcUtils.close(conn);
//        }

        return count;
    }

    @Override
    public int update(Row row, QueryBuilder queryBuilder) {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }

    @Override
    public int delete(QueryBuilder queryBuilder) {
        return 0;
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
        // 分页条件
        if (condition.isEnablePage()) {
            // 开始条数
            ps.setInt(values.size() + 1, condition.getFrom());
            // 查询条数
            ps.setInt(values.size() + 2, condition.getSize());
        }

        // ? set value
        for (int i = 0, len = values.size(); i < len; i++) {
            ps.setObject(i + 1, values.get(i));
        }

    }

    /**
     * 解析列
     * @param ps 预编译
     * @return 列
     * @exception SQLException 获取元数据异常
     */
    protected List<ColumnConstruction> analyzeColumn(PreparedStatement ps) throws SQLException{
        List<ColumnConstruction> list = new ArrayList<>();
        ResultSetMetaData metaData = ps.getMetaData();
        // 列数
        int count = metaData.getColumnCount();
        for (int i = 1; i < count + 1; i++) {
            ColumnConstruction column = new ColumnConstruction();
            // 列名
            column.setColumnName(metaData.getColumnName(i));
            // 列类型
            column.setColumnTypeEnum(analyzeColumnType(metaData.getColumnTypeName(i)));
            // 长度
            column.setLength(metaData.getColumnDisplaySize(i));
            // 经度
            column.setPrecision(metaData.getPrecision(i));
            // 允许为空
            column.setNull(metaData.isNullable(i) == 1);
            list.add(column);
        }
        return list;
    }

    /**
     * 生成列类型枚举
     * @param type 列类型
     * @return 列类型, 默认TEXT
     */
    protected ColumnTypeEnum analyzeColumnType(String type) {
        switch (type) {
            case "INT":
                return ColumnTypeEnum.INTEGER;
            case "CHAR":
                return ColumnTypeEnum.CHAR;
            case "VARCHAR":
                return ColumnTypeEnum.TEXT;
            case "FLOAT":
                return ColumnTypeEnum.FLOAT;
            case "DOUBLE":
                return ColumnTypeEnum.DOUBLE;
            case "DECIMAL":
                return ColumnTypeEnum.DECIMAL;
            case "DATE":
                return ColumnTypeEnum.DATE;
            case "DATETIME":
                return ColumnTypeEnum.TIMESTAMP;
            default:
                break;
        }
        return ColumnTypeEnum.TEXT;
    }

    /**
     * 结果解析
     * @param rs 结果街
     * @param columnList 列集合
     * @return 结果
     * @exception SQLException 解析异常
     */
    protected List<Row> analyzeResult(ResultSet rs, List<ColumnConstruction> columnList) throws SQLException{
        List<String> schema = new ArrayList<>(columnList.size());
        // 列名
        columnList.forEach(column -> schema.add(column.getColumnName()));

        // 返回结果
        List<Row> rowList = new LinkedList<>();
        while (rs.next()) {
            Row row = new Row();
            for (String name : schema) {
                row.put(name, rs.getObject(name));
            }
            rowList.add(row);
        }
        return rowList;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
