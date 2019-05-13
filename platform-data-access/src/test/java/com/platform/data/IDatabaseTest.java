package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.platform.data.builder.ColumnBuilders;
import com.platform.data.builder.MysqlTableBuilder;
import com.platform.data.builder.OracleTableBuilder;
import com.platform.data.builder.TableBuilders;
import com.platform.data.enums.ColumnTypeEnum;
import org.junit.Test;

import java.sql.SQLException;

public class IDatabaseTest {

    private static DruidDataSource oracleDataSource = new DruidDataSource();
    private static DruidDataSource mysqlDataSource = new DruidDataSource();

    private IDatabase oracle = new OracleDatabase(oracleDataSource);
    private IDatabase mysql = new MysqlDatabase(mysqlDataSource);

    static {
        oracleDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        oracleDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        oracleDataSource.setUsername("test");
        oracleDataSource.setPassword("123456");

        mysqlDataSource.setUrl("jdbc:mysql://192.168.240.128:3306/test?characterEncoding=utf8&useSSL=true");
        mysqlDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        mysqlDataSource.setUsername("root");
        mysqlDataSource.setPassword("123456");
    }

    @Test
    public void getAllTableNameTest() throws SQLException {
        System.out.println(oracle.getAllTableName());
        System.out.println(mysql.getAllTableName());
    }

    @Test
    public void createTableTest() throws SQLException{
//        Table table = new Table("user_info")
//                .addColumn(new Column("id", ""));

        TableBuilders tableBuilder = new TableBuilders()
                .tableName("user_info")
                .addColumn(
                        new ColumnBuilders().columnName("user_id").columnType(ColumnTypeEnum.INTEGER).isNull(false),
                        new ColumnBuilders().columnName("sex_1").columnType(ColumnTypeEnum.CHAR),
                        new ColumnBuilders().columnName("name").columnType(ColumnTypeEnum.STRING).length(32),
                        new ColumnBuilders().columnName("sex").columnType(ColumnTypeEnum.INTEGER).defaultValue(0),
                        new ColumnBuilders().columnName("age").columnType(ColumnTypeEnum.INTEGER).defaultValue(18),
                        new ColumnBuilders().columnName("height").columnType(ColumnTypeEnum.DECIMAL).length(10).precision(5),
                        new ColumnBuilders().columnName("width").columnType(ColumnTypeEnum.FLOAT),
                        new ColumnBuilders().columnName("width_1").columnType(ColumnTypeEnum.DOUBLE),
                        new ColumnBuilders().columnName("birth_date").columnType(ColumnTypeEnum.DATE),
                        new ColumnBuilders().columnName("description").columnType(ColumnTypeEnum.TEXT),
                        new ColumnBuilders().columnName("create_time").columnType(ColumnTypeEnum.TIMESTAMP)
                );
        System.out.println(tableBuilder.buildSql(new MysqlTableBuilder(), false));
        System.out.println(tableBuilder.buildSql(new MysqlTableBuilder(), true));
//        System.out.println(tableBuilder.buildSql(new OracleTableBuilder(), false));
//        System.out.println(tableBuilder.buildSql(new OracleTableBuilder(), true));
    }

}
