package com.platform.data;

import javax.sql.DataSource;

public interface IDatabaseFactory {

    /**
     * 连接数据库
     * @param dataSource 数据源
     * @return 结果
     */
    IDatabase openDatabase(DataSource dataSource);

}
