package com.nieyue.controller.test;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.nieyue.controller.ManagerController;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:config/spring-dao.xml","classpath:config/spring-service.xml","classpath:config/springmvc-servlet.xml"})
public class UserControllerTest {
	@Resource
	ManagerController managerController;
	@Resource
	WebApplicationContext wac;
	MockHttpServletRequest request=new MockHttpServletRequest();
	MockHttpServletResponse response=new MockHttpServletResponse();
	MockMvc mvc;
	@Before
	public void setUp(){
		this.mvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	@Test
	public void testTest1() {
		fail("Not yet implemented");
	}

	@Test
	public void testTest2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectUserByID() {
		fail("Not yet implemented");
	}
	@Test
	public void xsdfsdfsd() throws Exception {
		Integer type=1;//0是get
		String url="";
		//String url="/1000.xml";
		//String url="/manager/login?managerPhone=15111336587&managerPassword=123456";//退款
		//String url="/news/delete/review";//删除去重
		 //url="/news/grab?url=http://t.kejixun.com/list/6&mode=热点";//新闻抓取
		//for (int i = 0; i < 100; i++) {
			// url="/news/grab?url=http://3g.k.sohu.com/t/n"+Integer.valueOf(152233000+i)+"&mode=新浪";//新闻抓取
		 //url="/news/list?pageNum=11&pageSize=10&type=热点&orderName=news_id&orderWay=asc";//list
		 //url="/news/list?pageNum=11&pageSize=10&type=首页&orderName=news_id&orderWay=asc";//list
		 //url="/news/list/random?pageSize=10";//list
		url="/news/types";//type list
		if(type.equals(0)){
		this.mvc.perform(get(url))
		//.andExpect(status().isOk())
		.andDo(print());
		return;
		}
		this.mvc.perform(post(url))
		//.andExpect(status().isOk())
		.andDo(print());
		//}
		
	}

	@Test
	public void testModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testJs() {
		fail("Not yet implemented");
	}

	@Test
	public void testRp() {
		fail("Not yet implemented");
	}

}
