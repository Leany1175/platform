package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.entity.Row;
import com.platform.data.mysql.MysqlDatabase;
import com.platform.data.mysql.MysqlTableBuilder;
import com.platform.data.oracle.OracleTableBuilder;
import com.platform.data.builder.table.TableBuilders;
import com.platform.data.enums.ColumnTypeEnum;
import com.platform.data.oracle.OracleDatabase;
import com.platform.data.query.QueryBuilder;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
//        oracle.createTable(tableBuilder);
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

    @Test
    public void queryTest() throws SQLException{
        String tableName = "user_info";

        QueryBuilder queryBuilder = new QueryBuilder()
                .like("name", "张三")
                .desc("create_time")
                .asc("sex")
                .enablePage(true);

        ITable mysqlTable = mysql.getTable(tableName);
        mysqlTable.query(queryBuilder);

//        ITable oracleTable = oracle.getTable(tableName);
//        oracleTable.query(queryBuilder);

    }




    @Test
    public void insertTest() throws SQLException{
        String tableName = "user_info";

        Row row = new Row()
                .add("user_id", 1)
                .add("name", "张三")
                .add("create_time", new Date())
                .add("birth_date", new Date())
                .add("sex", 0);

        ITable mysqlTable = mysql.getTable(tableName);
        mysqlTable.insert(row);

//        ITable oracleTable = oracle.getTable(tableName);
//        oracleTable.insert(row);
    }

    @Test
    public void insertMoreTest() throws SQLException{
        String tableName = "user_info";


        Row row = new Row()
                .add("user_id", 2)
                .add("name", "李四")
                .add("sex", 0)
                .add("create_time", new Date());
        Row row1 = new Row()
                .add("user_id", 3)
                .add("name", "王二")
                .add("sex", 0)
                .add("create_time", new Date());
        Row row2 = new Row()
                .add("user_id", 4)
                .add("name", "麻子")
                .add("sex", 1)
                .add("create_time", new Date());
        List<Row> rowList = new ArrayList<>();
        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);

        ITable mysqlTable = mysql.getTable(tableName);
        System.out.println(JSON.toJSONString(mysqlTable.insert(rowList)));

        ITable oracleTable = oracle.getTable(tableName);
        System.out.println(JSON.toJSONString(oracleTable.insert(rowList)));
    }

}
