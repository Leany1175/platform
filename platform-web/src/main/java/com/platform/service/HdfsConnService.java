package com.platform.service;

import com.platform.dto.HdfsDto;

public interface HdfsConnService {

    /**
     * 保存树和附加信息
     * @param dto 数据
     */
    void saveHdfsConn(HdfsDto dto);

}
