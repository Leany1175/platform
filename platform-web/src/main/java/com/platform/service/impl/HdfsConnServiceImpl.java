package com.platform.service.impl;

import com.platform.dto.HdfsDto;
import com.platform.entity.HdfsConnInfo;
import com.platform.entity.TreeBean;
import com.platform.repository.HdfsConnRepository;
import com.platform.repository.TreeRepository;
import com.platform.service.HdfsConnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HdfsConnServiceImpl implements HdfsConnService {

    @Autowired
    private HdfsConnRepository hdfsConnRepository;

    @Autowired
    private TreeRepository treeRepository;

    @Override
    public void saveHdfsConn(HdfsDto dto) {
        // 父节点
        TreeBean parent = treeRepository.findOne(dto.getParentId());

        TreeBean treeBean = new TreeBean();
        // 节点名称
        treeBean.setTitle(dto.getName());
        // 是否是树叶节点
        treeBean.setIsLast(!dto.getIsCatalog());
        // 节点深度
        treeBean.setLevel(parent.getLevel() != null ? parent.getLevel() + 1 : 0);
        // parentId
        treeBean.setParentId(dto.getParentId());
        treeBean.setCreateTime(new Date());

        // 保存
        treeRepository.save(treeBean);
        
        if (!dto.getIsCatalog()) {
            HdfsConnInfo connInfo = new HdfsConnInfo();
            connInfo.setName(dto.getName());
            connInfo.setIp(dto.getIp());
            connInfo.setPort(Integer.parseInt(dto.getPort()));
            connInfo.setUsername(dto.getUsername());
            connInfo.setCreateTime(new Date());
            connInfo.setNode(treeBean);

            // 保存
            hdfsConnRepository.save(connInfo);
        }

    }


}
