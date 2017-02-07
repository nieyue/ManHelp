package com.nieyue.dao;

import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.Manager;

/**
 * 管理接口
 * @author yy
 *
 */
public interface ManagerDao {
	/** 账户登录 */
	public Manager managerLogin(@Param("name")String name,@Param("password")String password);	
}
