package com.platform.data.oracle;

import com.platform.data.ITable;
import com.platform.data.base.BaseDatabase;
import com.platform.data.util.JdbcUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleDatabase extends BaseDatabase {

	public OracleDatabase(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public List<String> getAllTableName() throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement ps = connection.prepareStatement("select TABLE_NAME from TABS");
		ResultSet rs = ps.executeQuery();
		List<String> nameList = new ArrayList<>();
		while (rs.next()) {
			nameList.add(rs.getString(1));
		}
		JdbcUtil.close(connection, ps, rs);
		return nameList;
	}

	@Override
	public ITable getTable(String tableName) throws SQLException {
		return null;
	}

}
