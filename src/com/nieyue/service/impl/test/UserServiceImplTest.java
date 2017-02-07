package com.nieyue.service.impl.test;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.util.AssertionErrors;

import com.nieyue.bean.User;
import com.nieyue.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring-dao.xml","classpath:config/spring-service.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class UserServiceImplTest {
	@Resource
	UserService userService;
	
	@Test
	public void testUserLogin() {
		String name="15111336587";
		String password="123456";
		User u = userService.userLogin(name,password);
		System.out.println(u);
	}

	@Test
	public void testChkLoginName() {
		String name="15111336587";
		boolean s = userService.chkLoginName(name);
		AssertionErrors.assertEquals("错误", s, true);
	}

	@Test
	public void testRetrieveAccount() {
		String name="15111336587";
		User u = userService.retrieveAccount(name);
		AssertionErrors.fail(u.toString());
		//AssertionErrors.assertEquals("错误", u, new User());

	}

	@Test
	public void testAddUser() {
		User user=new User();
		String name="111111111";
		String password="123456";
		user.setName(name);
		user.setPassword(password);
		userService.addUser(user);
	}

	@Test
	public void testUpdateUser() {
		User u = userService.loadUser(1006);
		u.setNiceName("聂跃6");
		userService.updateUser(u);
	}

	@Test
	public void testSearchUser() {
		List<User> l = userService.searchUser(-33, 3);
		for (Iterator<User> iterator = l.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user);
		}
	}

	@Test
	public void testBrowseUser() {
		List<User> l = userService.browseUser();
		for (User user : l) {
			System.out.println(user);
		}
	}

	@Test
	public void testDelUser() {
		userService.delUser(1006);
	}

	@Test
	public void testLoadUser() {
		User u = userService.loadUser(1000);
		System.out.println(u);
	}

}
