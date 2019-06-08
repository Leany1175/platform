package com.platform.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.platform.data.builder.column.ColumnBuilder;
import com.platform.data.builder.table.ITableBuilder;
import com.platform.data.builder.table.TableBuilder;
import com.platform.data.mysql.MysqlDatabaseFactory;
import com.platform.data.mysql.MysqlTableBuilder;
import com.platform.data.oracle.OracleDatabaseFactory;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DBTest {

    private static IDatabaseFactory mysqlDatabaseFactory = new MysqlDatabaseFactory();
    private static IDatabaseFactory oracleDatabaseFactory = new OracleDatabaseFactory();
    private static IDatabase mysqlDatabase;
    private static IDatabase oracleDatabase;

    private static TableBuilder tableBuilder;
    private static List<ColumnBuilder> columnBuilderList;
    private static DruidDataSource mysqlDatasource = new DruidDataSource();;
    private static DruidDataSource oracleDatasource = new DruidDataSource();

    static {

        mysqlDatasource.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=true");
        mysqlDatasource.setDriverClassName("com.mysql.jdbc.Driver");
        mysqlDatasource.setUsername("root");
        mysqlDatasource.setPassword("123456");
        mysqlDatabase = mysqlDatabaseFactory.openDatabase(mysqlDatasource);

        oracleDatasource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        oracleDatasource.setDriverClassName("oracle.jdbc.OracleDriver");
        oracleDatasource.setUsername("test");
        oracleDatasource.setPassword("123456");
        oracleDatabase = oracleDatabaseFactory.openDatabase(oracleDatasource);

        columnBuilderList = new ArrayList<>();
        columnBuilderList.addAll(Arrays.asList(
                new ColumnBuilder().columnName("column_1").columnType(Types.BIT),
                new ColumnBuilder().columnName("column_2").columnType(Types.TINYINT),
                new ColumnBuilder().columnName("column_3").columnType(Types.SMALLINT),
                new ColumnBuilder().columnName("column_4").columnType(Types.INTEGER),
                new ColumnBuilder().columnName("column_5").columnType(Types.BIGINT),
                new ColumnBuilder().columnName("column_6").columnType(Types.FLOAT),
                new ColumnBuilder().columnName("column_7").columnType(Types.REAL),
                new ColumnBuilder().columnName("column_8").columnType(Types.DOUBLE),
                new ColumnBuilder().columnName("column_9").columnType(Types.NUMERIC),
                new ColumnBuilder().columnName("column_10").columnType(Types.DECIMAL).length(10).precision(3),
                new ColumnBuilder().columnName("column_11").columnType(Types.CHAR),
                new ColumnBuilder().columnName("column_12").columnType(Types.VARCHAR).length(32),
                new ColumnBuilder().columnName("column_13").columnType(Types.LONGVARCHAR).length(64),
                new ColumnBuilder().columnName("column_14").columnType(Types.DATE),
                new ColumnBuilder().columnName("column_15").columnType(Types.TIME),
                new ColumnBuilder().columnName("column_16").columnType(Types.TIMESTAMP),
                new ColumnBuilder().columnName("column_17").columnType(Types.BINARY),
                new ColumnBuilder().columnName("column_18").columnType(Types.VARBINARY).length(32),
                new ColumnBuilder().columnName("column_19").columnType(Types.LONGVARBINARY).length(32),
                new ColumnBuilder().columnName("column_20").columnType(Types.NULL),
                new ColumnBuilder().columnName("column_21").columnType(Types.OTHER),
                new ColumnBuilder().columnName("column_22").columnType(Types.JAVA_OBJECT),
                new ColumnBuilder().columnName("column_23").columnType(Types.DISTINCT),
                new ColumnBuilder().columnName("column_24").columnType(Types.STRUCT),
                new ColumnBuilder().columnName("column_25").columnType(Types.ARRAY),
                new ColumnBuilder().columnName("column_26").columnType(Types.BLOB),
                new ColumnBuilder().columnName("column_27").columnType(Types.CLOB),
                new ColumnBuilder().columnName("column_28").columnType(Types.REF),
                new ColumnBuilder().columnName("column_29").columnType(Types.DATALINK),
                new ColumnBuilder().columnName("column_30").columnType(Types.BOOLEAN),
                new ColumnBuilder().columnName("column_31").columnType(Types.ROWID),
                new ColumnBuilder().columnName("column_32").columnType(Types.NCHAR).length(32),
                new ColumnBuilder().columnName("column_33").columnType(Types.NVARCHAR).length(32),
                new ColumnBuilder().columnName("column_34").columnType(Types.LONGNVARCHAR).length(32),
                new ColumnBuilder().columnName("column_35").columnType(Types.NCLOB),
                new ColumnBuilder().columnName("column_36").columnType(Types.SQLXML),
                new ColumnBuilder().columnName("column_37").columnType(Types.REF_CURSOR),
                new ColumnBuilder().columnName("column_38").columnType(Types.TIME_WITH_TIMEZONE),
                new ColumnBuilder().columnName("column_39").columnType(Types.TIMESTAMP_WITH_TIMEZONE)
        ));


        /***** table *****/
        tableBuilder = new TableBuilder()
                .tableName("users_info")
                .addColumn(columnBuilderList);
    }

    @Test
    public void getAllTableNameTest() throws SQLException {
        Set<String> mysqlTableNameSet = mysqlDatabase.getAllTableName();
        System.out.println(mysqlTableNameSet);

        Set<String> oracleTableNameSet = oracleDatabase.getAllTableName();
        System.out.println(oracleTableNameSet);
    }

    @Test
    public void createTableTest() throws SQLException{
        TableBuilder tableBuilder = new TableBuilder()
                .tableName("demo_table")
                .addColumn(
//                        columnBuilderList.get(0),

                        columnBuilderList.get(1),
                        columnBuilderList.get(2),
                        columnBuilderList.get(3),
                        columnBuilderList.get(4),
                        columnBuilderList.get(5),

                        columnBuilderList.get(6),
                        columnBuilderList.get(7),
                        columnBuilderList.get(8),
                        columnBuilderList.get(9),
                        columnBuilderList.get(10),

                        columnBuilderList.get(11),
                        columnBuilderList.get(12),
                        columnBuilderList.get(13),
                        columnBuilderList.get(14),
                        columnBuilderList.get(15),

                        columnBuilderList.get(16),
                        columnBuilderList.get(17),
                        columnBuilderList.get(18),
                        columnBuilderList.get(19),
                        columnBuilderList.get(20),

                        columnBuilderList.get(21),
                        columnBuilderList.get(22),
                        columnBuilderList.get(23),
                        columnBuilderList.get(24),
                        columnBuilderList.get(25),

                        columnBuilderList.get(26),
                        columnBuilderList.get(27),
                        columnBuilderList.get(28),
                        columnBuilderList.get(29),
                        columnBuilderList.get(30),

                        columnBuilderList.get(31),
                        columnBuilderList.get(32),
                        columnBuilderList.get(33),
                        columnBuilderList.get(34),
                        columnBuilderList.get(35),

                        columnBuilderList.get(36),
                        columnBuilderList.get(37),
                        columnBuilderList.get(38),

                        columnBuilderList.get(0)
                );

        ITableBuilder mysqlTableBuild = new MysqlTableBuilder();
//        System.out.println(mysqlTableBuild.build(tableBuilder, false));
        String sql = mysqlTableBuild.build(tableBuilder, true);
        System.out.println(sql);


        // TODO
        executeUpdate("drop table demo_table");
        executeUpdate(sql);
        print();
    }

    private void executeUpdate(String sql) throws SQLException{
        Connection conn = mysqlDatasource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    private void print() throws SQLException{
        Connection conn = mysqlDatasource.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from demo_table");
        ResultSetMetaData metaData = ps.getMetaData();
        int count = metaData.getColumnCount();
        for (int i = 1, len = count + 1; i < len; i++) {
            System.out.println("getColumnName:" + metaData.getColumnName(i));
            System.out.println("getColumnTypeName:" + metaData.getColumnTypeName(i));
            System.out.println("getColumnClassName:" + metaData.getColumnClassName(i));
            System.out.println("---------------------------------");
        }
    }


}
