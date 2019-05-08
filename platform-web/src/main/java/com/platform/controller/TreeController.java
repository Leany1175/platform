package com.platform.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.platform.service.TreeService;

@Controller
@Scope("prototype")
@RequestMapping("/admin/tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    /**
     * 根节点
     * @return dtree返回数据格式
     */
    @ResponseBody
    @RequestMapping(value = "/root", method = { RequestMethod.GET, RequestMethod.POST })
    public Map<String, Object> root() {
        Map<String, Object> map = new HashMap<>();
        // 状态
        Map<String, Object> status = new HashMap<>();
        status.put("code", 200);
        status.put("message", "操作成功");
        map.put("status", status);
        // data
        map.put("data", treeService.root());
        return map;
    }
    
    

}
