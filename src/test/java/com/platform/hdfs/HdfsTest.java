package com.platform.hdfs;

import com.alibaba.fastjson.JSON;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

public class HdfsTest {

    @Test
    public void lsTest() throws InterruptedException, IOException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create("hdfs://192.168.244.129:9000/"), conf, "root");
        FileStatus[] statuses = fs.listStatus(new Path("/"));
        for (FileStatus status : statuses) {
            System.out.println(status);
        }
        System.out.println("done");
    }

}
