package com.platform.entity;

import com.alibaba.fastjson.JSON;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "b_admin")
public class Administrator implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "admin_id", length = 32)
	@GenericGenerator(name = "uuidGenerator", strategy = "uuid")
	@GeneratedValue(generator = "uuidGenerator")
	private String adminId;

	/** 手机号 */
	@Column(name = "phone", length = 11)
	private String phone;

	/** 密码 */
	@Column(name = "password", length = 32)
	private String password;

	/** 创建时间 */
	@Column(name = "create_time")
	private Date createTime;

	/** 上次更新 */
	@Column(name = "last_update")
	private Date lastUpdate;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

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
