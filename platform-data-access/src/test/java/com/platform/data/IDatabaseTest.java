package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.mysql.MysqlDatabase;
import com.platform.data.mysql.MysqlTableBuilder;
import com.platform.data.oracle.OracleTableBuilder;
import com.platform.data.builder.table.TableBuilders;
import com.platform.data.enums.ColumnTypeEnum;
import com.platform.data.oracle.OracleDatabase;
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

        mysqlDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=true");
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
        TableBuilders tableBuilder = new TableBuilders()
                .tableName("user_info")
                .addColumn(
                        new ColumnBuilders().columnName("user_id").columnType(ColumnTypeEnum.INTEGER).isNull(false),
                        new ColumnBuilders().columnName("sex_1").columnType(ColumnTypeEnum.CHAR).length(4),
                        new ColumnBuilders().columnName("name").columnType(ColumnTypeEnum.STRING).length(32),
                        new ColumnBuilders().columnName("sex").columnType(ColumnTypeEnum.INTEGER).length(11).defaultValue(0),
                        new ColumnBuilders().columnName("age").columnType(ColumnTypeEnum.INTEGER).length(4).defaultValue(18),
                        new ColumnBuilders().columnName("height").columnType(ColumnTypeEnum.DECIMAL).length(10).precision(5),
                        new ColumnBuilders().columnName("width").columnType(ColumnTypeEnum.FLOAT),
                        new ColumnBuilders().columnName("width_1").columnType(ColumnTypeEnum.DOUBLE),
                        new ColumnBuilders().columnName("birth_date").columnType(ColumnTypeEnum.DATE),
                        new ColumnBuilders().columnName("description").columnType(ColumnTypeEnum.TEXT),
                        new ColumnBuilders().columnName("create_time").columnType(ColumnTypeEnum.TIMESTAMP)
                );
//        System.out.println(tableBuilder.buildSql(new MysqlTableBuilder(), false));
        System.out.println(tableBuilder.buildSql(new MysqlTableBuilder(), true));
//        System.out.println(tableBuilder.buildSql(new OracleTableBuilder(), false));
        System.out.println(tableBuilder.buildSql(new OracleTableBuilder(), true));

        mysql.createTable(tableBuilder);
        oracle.createTable(tableBuilder);
    }

    @Test
    public void dropTableTest() throws SQLException{
        mysql.dropTable("user_info");
        oracle.dropTable("user_info");
    }









    @Test
    public void addColumnTest() throws SQLException{
        String tableName = "user_info";
        ColumnBuilders columnBuilders = new ColumnBuilders().columnName("test_column_name").columnType(ColumnTypeEnum.STRING).length(32).defaultValue("test").isNull(false);

        ITable mysqlTable = mysql.getTable(tableName);
        System.out.println(mysqlTable.getTableName());
        mysqlTable.addColumn(columnBuilders);

        ITable oracleTable = oracle.getTable(tableName);
        System.out.println(oracleTable.getTableName());
        oracleTable.addColumn(columnBuilders);
    }

    @Test
    public void modifyColumnTest() throws SQLException{
        ColumnBuilders columnBuilders = new ColumnBuilders().columnName("test_column_name").columnType(ColumnTypeEnum.STRING).length(64);
        String tableName = "user_info";

        ITable mysqlTable = mysql.getTable(tableName);
        mysqlTable.modifyColumn(columnBuilders);

        ITable oracleTable = oracle.getTable(tableName);
        oracleTable.modifyColumn(columnBuilders);
    }

    @Test
    public void renameColumnTest() throws SQLException{
        String tableName = "user_info";
        ColumnBuilders columnBuilders = new ColumnBuilders().columnName("test_column_name_1").columnType(ColumnTypeEnum.STRING).length(64);

        ITable mysqlTable = mysql.getTable(tableName);
        mysqlTable.renameColumn("test_column_name", columnBuilders);

        ITable oracleTable = oracle.getTable(tableName);
        oracleTable.renameColumn("test_column_name", columnBuilders);
    }

    @Test
    public void dropColumnTest() throws SQLException{
        String tableName = "user_info";

        ITable mysqlTable = mysql.getTable(tableName);
        mysqlTable.dropColumn("test_column_name_1");

        ITable oracleTable = oracle.getTable(tableName);
        oracleTable.dropColumn("test_column_name_1");
    }

}
