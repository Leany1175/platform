package com.platform.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "b_hdfs_conn_info")
public class HdfsConnInfo implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", length = 32)
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @GeneratedValue(generator = "uuidGenerator")
    private String id;

    @Column(name = "name", length = 32)
	private String name;

    @Column(name = "ip", length = 32)
    private String ip;

    @Column(name = "port")
    private Integer port;

    @Column(name = "username", length = 32)
    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "node_id")
    private TreeBean node;

    /** 创建时间 */
    @Column(name = "create_time")
    private Date createTime;

    /** 上次更新 */
    @Column(name = "last_update")
    private Date lastUpdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TreeBean getNode() {
        return node;
    }

    public void setNode(TreeBean node) {
        this.node = node;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
