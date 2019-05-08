package com.platform.data;

import com.platform.data.entity.Row;

import java.util.List;

/**
 * 查询结果
 */
public interface ISearchResult {

	/**
	 * 所有行
	 * @return
	 */
	List<Row> getRowList();

	/**
	 * 总条数
	 * @return
	 */
	int getTotalCount();

	/**
	 * 当前页号
	 * @return
	 */
	default int getCurrentPage() {
		return 1;
	}

	/**
	 * 总条数
	 * @return
	 */
	default int getSize() {
		return 10;
	}

	/**
	 * 总页数
	 * @return
	 */
	default int getTotalPage() {
		// 总条数
		int totalCount = getTotalCount();
		// 条数
		int size = getSize();
		return totalCount % size == 0 ? totalCount / size : totalCount / size + 1;
	}

}
