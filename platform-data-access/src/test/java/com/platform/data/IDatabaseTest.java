package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.builder.table.TableBuilders;
import com.platform.data.entity.Row;
import com.platform.data.enums.ColumnTypeEnum;
import com.platform.data.mysql.MysqlDatabase;
import com.platform.data.oracle.OracleDatabase;
import com.platform.data.query.QueryBuilder;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IDatabaseTest {

    private static DruidDataSource oracleDataSource = new DruidDataSource();
    private static DruidDataSource mysqlDataSource = new DruidDataSource();

    private IDatabase oracle = new OracleDatabase(oracleDataSource);
    private IDatabase mysql = new MysqlDatabase(mysqlDataSource);

    private String tableName = "user_info";

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
    public void test() throws SQLException{
        Connection conn = mysqlDataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from user_info limit 0, 10");
//        ps.setInt(1, 0);
//        ps.setInt(2, 10);
        ps.getMetaData();
        ps.executeQuery();
    }

    @Test
    public void getAllTableNameTest() throws SQLException {
        System.out.println(oracle.getAllTableName());
        System.out.println(mysql.getAllTableName());
    }

    @Test
    public void createTableTest() throws SQLException{
        TableBuilders tableBuilder = new TableBuilders()
                .tableName(tableName)
                .addColumn(
                        new ColumnBuilders().columnName("id").columnType(ColumnTypeEnum.INTEGER).isNull(false),
                        new ColumnBuilders().columnName("sex").columnType(ColumnTypeEnum.CHAR).length(4),
                        new ColumnBuilders().columnName("name").columnType(ColumnTypeEnum.STRING).length(32),
                        new ColumnBuilders().columnName("age").columnType(ColumnTypeEnum.INTEGER).length(4).defaultValue(18),
                        new ColumnBuilders().columnName("width").columnType(ColumnTypeEnum.FLOAT),
                        new ColumnBuilders().columnName("height").columnType(ColumnTypeEnum.DOUBLE),
                        new ColumnBuilders().columnName("weight").columnType(ColumnTypeEnum.DECIMAL).length(10).precision(4),
                        new ColumnBuilders().columnName("birth_date").columnType(ColumnTypeEnum.DATE),
                        new ColumnBuilders().columnName("create_time").columnType(ColumnTypeEnum.TIMESTAMP),
                        new ColumnBuilders().columnName("description").columnType(ColumnTypeEnum.TEXT)
                );

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
                .like("name", "张")
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

        Row row = new Row()
                .add("id", 1)
                .add("sex", 1)
                .add("name", "张小三")
                .add("age", 18)
                .add("width", 66.6)
                .add("height", 33.3)
                .add("weight", 22.3)
                .add("birth_date", new Date())
                .add("create_time", new Date());

        ITable mysqlTable = mysql.getTable(tableName);
        mysqlTable.insert(row);

        ITable oracleTable = oracle.getTable(tableName);
        oracleTable.insert(row);
    }

    @Test
    public void insertMoreTest() throws SQLException{
        String tableName = "user_info";


        Row row = new Row()
                .add("id", 1)
                .add("sex", 1)
                .add("name", "李四")
                .add("age", 18)
                .add("width", 66.6)
                .add("height", 33.3)
                .add("weight", 22.3)
                .add("birth_date", new Date())
                .add("create_time", new Date());
        Row row1 = new Row()
                .add("id", 1)
                .add("sex", 1)
                .add("name", "李四")
                .add("age", 18)
                .add("width", 66.6)
                .add("height", 33.3)
                .add("weight", 22.3)
                .add("birth_date", new Date())
                .add("create_time", new Date());
        Row row2 = new Row()
                .add("id", 1)
                .add("sex", 1)
                .add("name", "李四")
                .add("age", 18)
                .add("width", 66.6)
                .add("height", 33.3)
                .add("weight", 22.3)
                .add("birth_date", new Date())
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
