package com.platform.service.impl;

import com.platform.entity.TreeBean;
import com.platform.repository.TreeRepository;
import com.platform.service.TreeService;
import org.apache.commons.collections.bag.TreeBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeRepository treeRepository;

    @Override
    public TreeBean root() {
        // 查询所有
        List<TreeBean> list = treeRepository.findAll();
        // 查找根节点
        TreeBean root = findRoot(list);
        TreeBean treeBean = findChildren(root, list);
        return treeBean;
    }

    private TreeBean findChildren(TreeBean treeBean, List<TreeBean> list) {
        for (TreeBean children : list) {
            if (treeBean.getId().equals(children.getParentId())) {
                if (treeBean.getChildren() == null) {
                    treeBean.setChildren(new ArrayList<>());
                }
                treeBean.getChildren().add(findChildren(children, list));
            }
        }
        return treeBean;
    }

    /**
     * 查询根节点
     * @param list 列表
     * @return 根节点
     */
    private TreeBean findRoot(List<TreeBean> list) {
        for (TreeBean treeBean : list) {
            if ("root".equalsIgnoreCase(treeBean.getId())) {
                return treeBean;
            }
        }
        throw new NullPointerException("root节点不存在");
    }

}
