package com.nieyue.service;

import com.nieyue.bean.Manager;
/**
 * 管理接口
 * @author yy
 *
 */
public interface ManagerService {
	/** 账户登录 */
	public Manager managerLogin(String name,String password);	

}
