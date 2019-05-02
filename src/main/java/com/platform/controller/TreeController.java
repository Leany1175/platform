package com.platform.controller;

import com.platform.entity.TreeBean;
import com.platform.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/admin/tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @ResponseBody
    @RequestMapping(value = "/root", method = RequestMethod.GET)
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
