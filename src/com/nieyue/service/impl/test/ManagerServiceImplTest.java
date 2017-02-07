package com.nieyue.service.impl.test;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.nieyue.bean.Manager;
import com.nieyue.service.ManagerService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring-dao.xml","classpath:config/spring-service.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class ManagerServiceImplTest {
	@Resource
	ManagerService managerService;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testManagerLogin() {
		String name="15111336587";
		String password="123456";
		Manager manager = managerService.managerLogin(name, password);
		System.out.println(manager.getManagerId());
	}

}
