package com.platform.service;

import java.util.List;

import com.platform.entity.TreeBean;

public interface TreeService {

    /**
     * 树查询
     * @return 树
     */
    List<TreeBean> root();

}
