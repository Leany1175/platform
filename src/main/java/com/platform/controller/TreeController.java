package com.platform.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.platform.service.TreeService;

@Controller
@Scope("prototype")
@RequestMapping("/admin/tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

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
        System.out.println(JSON.toJSONString(map, true));
        return map;
    }
    
//    @ResponseBody
//    @RequestMapping(value = "/root", method = { RequestMethod.GET, RequestMethod.POST })
//    public String root() {
//    	return "{\r\n" + 
//    			"	\"status\": {\r\n" + 
//    			"		\"code\": 200,\r\n" + 
//    			"		\"message\": \"操作成功\"\r\n" + 
//    			"	},\r\n" + 
//    			"	\"data\": [\r\n" + 
//    			"		{\r\n" + 
//    			"			\"id\": \"root\",\r\n" + 
//    			"			\"title\": \"ROOT\",\r\n" + 
//    			"			\"isLast\": false,\r\n" + 
//    			"			\"level\": \"1\",\r\n" + 
//    			"			\"parentId\": \"NONE\",\r\n" + 
//    			"			\"children\": [\r\n" + 
//    			"				{\r\n" + 
//    			"					\"id\": \"01\",\r\n" + 
//    			"					\"title\": \"目录\",\r\n" + 
//    			"					\"isLast\": false,\r\n" + 
//    			"					\"parentId\": \"root\",\r\n" + 
//    			"					\"level\": \"2\",\r\n" + 
//    			"					\"children\": [\r\n" + 
//    			"						{\r\n" + 
//    			"							\"id\": \"001\",\r\n" + 
//    			"							\"title\": \"子文件\",\r\n" + 
//    			"							\"isLast\": true,\r\n" + 
//    			"							\"parentId\": \"01\",\r\n" + 
//    			"							\"level\": \"3\"\r\n" + 
//    			"						}\r\n" + 
//    			"					]\r\n" + 
//    			"				},\r\n" + 
//    			"				{\r\n" + 
//    			"					\"id\": \"02\",\r\n" + 
//    			"					\"title\": \"文件\",\r\n" + 
//    			"					\"isLast\": true,\r\n" + 
//    			"					\"parentId\": \"root\",\r\n" + 
//    			"					\"level\": \"2\"\r\n" + 
//    			"				}\r\n" + 
//    			"			]\r\n" + 
//    			"		}\r\n" + 
//    			"	]\r\n" + 
//    			"}\r\n" + 
//    			"";
//    }

}
