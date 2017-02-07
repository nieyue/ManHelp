package com.nieyue.dao.test;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nieyue.bean.Manager;
import com.nieyue.dao.ManagerDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-dao.xml")
public class ManagerDaoTest {
	@Resource
	ManagerDao managerDao;
	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testLogin() {
		  Manager manager = managerDao.managerLogin("15111336587", "123456");
		System.out.println(manager.getManagerPhone());
		System.out.println(manager.getManagerPassword());
	}

}
