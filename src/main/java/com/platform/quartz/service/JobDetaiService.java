package com.platform.quartz.service;

import com.platform.quartz.entity.QuartzJobDetails;
import com.platform.utils.layui.LayuiEntity;
import com.platform.utils.layui.LayuiTable;

public interface JobDetaiService{

    /**
     * 分页查询
     * @param table 当前页 + 条数
     * @return 查询结果
     */
    LayuiEntity<QuartzJobDetails> findPage(LayuiTable table);

}
