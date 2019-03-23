package com.platform.data.builder;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.platform.data.*;
import com.platform.data.util.JdbcUtil;

public abstract class BaseTable implements ITable {

	/** 表名 */
	protected String name;

	/** 数据源 */
	protected DataSource dataSource;

	public BaseTable(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public BaseTable(DataSource dataSource, String name) {
		this.dataSource = dataSource;
		this.name = name;
	}

	@Override
	public String getTableName() {
		return name;
	}

	@Override
	public void addColumn(IColumnBuilder columnBuilder) throws SQLException {
		JdbcUtil.executeUpdate(dataSource, "alter table " + name + " add column " + columnBuilder.build());
	}

	@Override
	public void modifyColumn(IColumnBuilder columnBuilder) throws SQLException {
		JdbcUtil.executeUpdate(dataSource, "alter table " + name + " modify " + columnBuilder.build());
	}

	@Override
	public void modifyColumn(String oldColumn, IColumnBuilder columnBuilder) throws SQLException{
		JdbcUtil.executeUpdate(dataSource, "alter table " + name + " change " + oldColumn + " " + columnBuilder.build());
	}

	@Override
	public void deleteColumn(String columnName) throws SQLException{
		JdbcUtil.executeUpdate(dataSource, "alter table " + name + " drop column " + columnName);
	}

	@Override
	public int columnCount() throws SQLException{
		return JdbcUtil.columnCount(dataSource, name);
	}

	@Override
	public List<Column> columnList() throws SQLException{
		return JdbcUtil.columnList(dataSource, name);
	}

//	@Override
//	public Iterator<Column> columnIterator() throws SQLException{
//		return columnList().iterator();
//	}

	@Override
	public PageModel<Row> queryPage(QueryBuilder queryBuilder) throws SQLException{
		// 行集
		List<Row> rowList = getRowList(dataSource, queryBuilder);

		// 查询总条数
		Connection conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(queryBuilder.buildCount());
		ResultSet rs = ps.executeQuery();
		// 总条数
		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
		}
		PageModel<Row> pm = new PageModel<>();
		// 当前页
		pm.setCurrentPage(queryBuilder.getQueryCondition().getPageNo());
		// 每页显示 条数
		pm.setSize(queryBuilder.getQueryCondition().getSize());
		// 数据
		pm.setList(rowList);
		// 总条数
		pm.setCount(count);
		// 关闭
		JdbcUtil.close(conn, ps, rs);
		return pm;
	}

	@Override
	public List<Row> queryAll(QueryBuilder queryBuilder) throws SQLException{
		// 禁用分页
		queryBuilder.enablePage(false);
		return getRowList(dataSource, queryBuilder);
	}

	@Override
	public int executeUpdate(Row row) throws SQLException{
		// TODO Auto-generated method stub
		// 主键名
		String pkName = null;
		// 主键值
		Object value = null;
		for (Map.Entry<Column, Object> entry : row.entrySet()) {
			if (entry.getKey().isPK()) {
				pkName = entry.getKey().getName();
				value = entry.getValue();
				break;
			}
		}

		if (pkName != null) {
			// 存在主键
			StringBuffer buffer = new StringBuffer("select * form ")
					.append(name)
					.append(" where ")
					.append(pkName)
					.append(" = ");
			if (value instanceof String) {
				buffer.append("'" + value + "'");
			} else {
				buffer.append(value);
			}
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(buffer.toString());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// 数据库存在这条记录 执行update
				// TODO 列名
				List<String> columnNameList = row.keysString();
				StringBuffer sql = new StringBuffer("insert into ")
						.append(name)
						.append("()")
						.append(" values()");
			}
		}

		return 0;
	}

	@Override
	public int executeUpdate(Row... rows) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(List<Row> rows) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRow(Row row) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRow(Row... row) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRow(List<Row> row) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 获取行集合
	 * @param dataSource 数据源
	 * @param queryBuilder 查询条件
	 * @return 行集
	 * @throws SQLException 异常
	 */
	protected List<Row> getRowList(DataSource dataSource, QueryBuilder queryBuilder) throws SQLException{
		// 设置表名
		queryBuilder.tableName(name);
		// 获取连接对象
		Connection conn = dataSource.getConnection();
		// 预编译
		PreparedStatement ps = conn.prepareStatement(queryBuilder.build());
		// 结果集
		ResultSet rs = ps.executeQuery();
		// 获取列信息
		List<Column> columnList = JdbcUtil.analysisColumns(dataSource, ps.getMetaData(),  name);
		// 行列表
		List<Row> rowList = new LinkedList<>();
		while (rs.next()) {
			Row row = new Row();
			for (int i = 1, len = columnList.size() + 1; i < len; i++) {
				row.put(columnList.get(i - 1), rs.getObject(i));
			}
			rowList.add(row);
		}
		// 关闭
		JdbcUtil.close(conn, ps, rs);
		return rowList;
	}

}
