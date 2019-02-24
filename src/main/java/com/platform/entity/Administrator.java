package com.platform.entity;

import java.io.Serializable;

public class Administrator implements Serializable{

	private String adminId;
	/** 手机号 */
	private String phone;
	/** 密码 */
	private String password;
	/** 创建时间 */
	private String createTime;
	/** 上次更新 */
	private String lastUpdate;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
