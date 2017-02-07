package com.nieyue.bean;

import java.io.Serializable;

/**
 * 管理员类
 * 
 * @author yy
 * 
 */
public class Manager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 管理员id
	 */
	private Integer managerId;
	
	/**
	 * 手机号
	 */
	private String managerPhone;
	/**
	 * 登录密码
	 */
	private String managerPassword;
	public Manager(Integer managerId, String managerPhone, String managerPassword) {
		super();
		this.managerId = managerId;
		this.managerPhone = managerPhone;
		this.managerPassword = managerPassword;
	}
	public Manager() {
		super();
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setMangerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
		
}
