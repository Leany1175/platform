package com.platform.data.oracle;

import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.base.BaseTable;
import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.entity.ColumnConstruction;
import com.platform.data.entity.Condition;
import com.platform.data.entity.Row;
import com.platform.data.query.IQueryBuilder;
import com.platform.data.query.ISearchResult;
import com.platform.data.query.QueryBuilder;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class OracleTable extends BaseTable {

    private static Logger logger = LoggerFactory.getLogger(OracleTable.class);

    public OracleTable(DataSource dataSource, String tableName) {
        super(dataSource, tableName);
    }

    @Override
    protected IColumnBuilder createColumnBuilder() {
        return new OracleColumnBuilder();
    }

    @Override
    protected IColumnBuilder createBuilder() {
        return new OracleColumnBuilder();
    }

    @Override
    protected IQueryBuilder createQueryBuild() {
        return new OracleQueryBuilder();
    }

    @Override
    public void addColumn(ColumnBuilders columnBuilders) throws SQLException {
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" add (")
                .append(columnBuilders.build(createBuilder()))
                .append(")");
        logger.debug("添加列:{}", buffer);
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    @Override
    public void modifyColumn(ColumnBuilders columnBuilders) throws SQLException{
        StringBuffer buffer = new StringBuffer("alter table ")
                .append(TABLE_NAME)
                .append(" modify (")
                .append(columnBuilders.build(createBuilder()))
                .append(")");
        logger.debug("修改列:{}", buffer);
        JdbcUtils.executeUpdate(dataSource, buffer.toString());
    }

    /**
     * 预编译,date类型有问题
     * @param ps 与编译
     * @param row 行
     * @throws SQLException
     */
    @Override
    protected void prepareValue(PreparedStatement ps, Row row) throws SQLException {
        // 下标,从1开始
        int i = 1;
        for (Map.Entry<String, Object> entry : row.entrySet()) {
            if (entry.getValue() instanceof Date) {
                ps.setObject(i, new java.sql.Timestamp(((Date) entry.getValue()).getTime()));
            } else {
                ps.setObject(i, entry.getValue());
            }
            i++;
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
            // 列名
            String colunmName = metaData.getColumnName(i);
            // r行号过滤
            if (!"r".equalsIgnoreCase(colunmName)) {
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
        }
        return list;
    }

}
