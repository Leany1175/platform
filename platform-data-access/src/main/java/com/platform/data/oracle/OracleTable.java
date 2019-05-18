package com.platform.data.oracle;

import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.base.BaseTable;
import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.entity.Row;
import com.platform.data.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

public class OracleTable extends BaseTable {

    private static Logger logger = LoggerFactory.getLogger(OracleTable.class);

    public OracleTable(DataSource dataSource, String tableName) {
        super(dataSource, tableName);
    }

    @Override
    protected IColumnBuilder createBuilder() {
        return new OracleColumnBuilder();
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
}
