package com.platform.utils.ajax;

import java.io.Serializable;

/**
 * ajax响应
 */
public class Result implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 500:错误,200:成功 */
	private int code = 500;
	/** 描述信息 */
	private String message = "";
	/** 数据 */
	private Object data;
	/** 跳转路径 */
	private String url;

	public Result() {
	}

	public Result(String message) {
		this.message = message;
	}

	public Result(int code, String message, String url) {
		this.code = code;
		this.message = message;
		this.url = url;
	}

	public Result(int code, Object data) {
		this.code = code;
		this.data = data;
	}

	public Result(int code, String message, Object data, String url) {
		this.code = code;
		this.message = message;
		this.data = data;
		this.url = url;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
