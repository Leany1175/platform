package com.platform.controller;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.platform.dto.HdfsDto;
import com.platform.service.HdfsConnService;
import com.platform.utils.ajax.Result;

@Controller
@Scope("prototype")
@RequestMapping("/admin/hdfs")
public class HdfsController {

    @Value("${hdfs.address}")
    private String hdfsAddr;

    @Autowired
    private HdfsConnService hdfsConnService;

    /**
     * 管理界面
     * @return 路径
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page() {
        return "admin/hdfs/hdfs-manager";
    }

    /**
     * 添加
     * @return 添加结果
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(HdfsDto hdfsDto) {
        // 验证
        String message = validateHdfsDto(hdfsDto);
        if (message != null) {
            return new Result(message);
        }
        
        Result result = new Result();
        try {
        	// 保存
        	hdfsConnService.saveHdfsConn(hdfsDto);
        	
        	result.setCode(200);
        	result.setMessage("保存成功");
		} catch (Exception e) {
			result.setMessage(e.getMessage());
		}

        return result;
    }

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

    /**
     * 数据验证
     * @param hdfsDto 保存树
     * @return 通过返回null
     */
    private String validateHdfsDto(HdfsDto hdfsDto) {
        if (hdfsDto.getName() == null || hdfsDto.getName().trim().isEmpty()) {
            return "名称不能为空";
        }
        if (hdfsDto.getName().length() > 32) {
            return "名称最多32个字符";
        }
        if (!hdfsDto.getIsCatalog()) {
        	if (hdfsDto.getIp() == null || hdfsDto.getIp().trim().isEmpty()) {
                return "ip不能为空";
            }
            if (hdfsDto.getPort() == null || hdfsDto.getPort().trim().isEmpty()) {
                return "端口不能为空";
            }
            Pattern pattern = Pattern.compile("^[1-9]+[0-9]*$");
            if (!pattern.matcher(hdfsDto.getPort()).matches()) {
                return "端口号为正整数";
            }
            if (hdfsDto.getUsername() == null || hdfsDto.getUsername().trim().isEmpty()) {
                return "用户名不能为空";
            }
            if (hdfsDto.getUsername().length() > 32) {
                return "用户名最多32个字符";
            }
        }
        
        return null;
    }

}
