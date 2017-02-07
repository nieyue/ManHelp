package com.nieyue.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nieyue.bean.News;
import com.nieyue.dao.NewsDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-dao.xml")
public class NewsDaoTest {
	@Resource
	NewsDao newsDao;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void  listnews(){
		List<News> l = newsDao.browseNews("体育", "news_id", "asc");
		System.out.println(l.size());
	}
	@Test
	public void  testLoadNews(){
		News n = newsDao.loadNews(1022);
		System.out.println(n.getTitle());
		System.out.println(n.getContent());
	}
	@Test
	public void  testLoadNews1(){
//		List<News> l = newsDao.browseRandomNews(10);
//		System.out.println(l.size());
//		System.out.println(l.get(3).getContent());
	}

}
