package com.platform.controller;

import com.platform.utils.ajax.Result;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
public class HdfsController {

    @Value("${hdfs.address}")
    private String hdfsAddr;

    @ResponseBody
    @RequestMapping(value = "/ls", method = RequestMethod.GET)
    public Result ls(String path) {
        Result result = new Result();
        try {
            FileSystem fs = FileSystem.get(URI.create(hdfsAddr), new Configuration(), "root");
            FileStatus[] statuses = fs.listStatus(new Path(path));
            Map<String, Object> map = new HashMap<>();
            for (FileStatus status : statuses) {
                map.put("path", status.getPath().getName());
                map.put("permission", status.getPermission());
                map.put("owner", status.getOwner());
            }
            result.setData(map);
            result.setCode(200);
        } catch (InterruptedException | IOException e) {
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

}
