package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.User;
import com.nieyue.dao.UserDao;
import com.nieyue.service.UserService;

/**
 * 用户业务实现类
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserDao userDao;
	/**
	 * 用户登录
	 */
	public User userLogin(String name, String password) {
		User u = userDao.userLogin(name, password);
		return u;
	}

	/**
	 * 检查用户是否存在
	 */
	@Override
	public boolean chkLoginName(String name) {
		boolean s = userDao.chkLoginName(name);
		return s;
	}

	/**
	 * 找回用户
	 */
	@Override
	public User retrieveAccount(String name) {
		User u = userDao.retrieveAccount(name);
		return u;
	}

	/**
	 * 增加用户
	 */
	@Override
	public boolean addUser(User user) {
		boolean b = userDao.addUser(user);
		return b;
	}

	/**
	 * 更新用户
	 */
	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	/**
	 * 浏览当前页用户
	 */
	@Override
	public List<User> searchUser(Integer pageNum, Integer pageSize) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<User> list = userDao.searchUser(pageNum-1, pageSize);
		return list;
	}

	/**
	 * 浏览所有用户
	 */
	@Override
	public List<User> browseUser() {
		List<User> l = userDao.browseUser();
		return l;
	}

	/**
	 * 删除用户
	 */
	@Override
	public boolean delUser(Integer userId) {
		return userDao.delUser(userId);
	}

	/**
	 * 加载单个用户
	 */
	@Override
	public User loadUser(Integer userId) {
		User u = userDao.loadUser(userId);
		return u;
	}
	/** 
	 * 微信隐形账户登录 
	 */
	@Override
	public User weixinBaseUserLogin(String openid) {
		User u = userDao.weixinBaseUserLogin(openid);
		return u;
	}

}
