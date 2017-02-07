package com.nieyue.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.Manager;
import com.nieyue.dao.ManagerDao;
import com.nieyue.service.ManagerService;

/**
 * 管理业务实现类
 * @author Administrator
 *
 */
@Service
public class ManagerServiceImpl implements ManagerService {
	@Resource
	ManagerDao managerDao;
	/**
	 * 登录
	 * @param manager
	 */
	@Override
	public Manager managerLogin(String name, String password) {
		Manager m = managerDao.managerLogin(name, password);
		return m;
	}
	
}
