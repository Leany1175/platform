package com.platform.dto;

public class HdfsDto {

    private String catalogId;
	/** 是不是目录 */
    private boolean isCatalog;
    private String parentId;
    private String level;
    private String name;
    private String ip;
    private String port;
    private String username;

    public boolean getIsCatalog() {
        return isCatalog;
    }

    public void setIsCatalog(boolean catalog) {
        isCatalog = catalog;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPort() {
        return port;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
