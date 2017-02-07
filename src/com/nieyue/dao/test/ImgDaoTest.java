package com.nieyue.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nieyue.bean.Img;
import com.nieyue.dao.ImgDao;
import com.nieyue.dao.NewsDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-dao.xml")
public class ImgDaoTest {
	@Resource
	NewsDao newsDao;
	@Resource
	ImgDao imgDao;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddImg() {
		for (int j = 0; j < 10; j++) {
			Img mig=new Img();
			mig.setImgId(1003);
			if(Math.random()*10>5){
				mig.setImgId(1004);
			}
			mig.setImgAddress("/resources/sellerUpload/7/黑茶/百两茶/百两茶_"+j+".jpg");
			imgDao.addImg(mig);
		}
	}

	@Test
	public void testDelImg() {
		imgDao.delImg(1019);
	}

	@Test
	public void testUpdateImg() {
		Img img = imgDao.loadImg(1018);
		img.setImgAddress("sdfdsf");
		imgDao.updateImg(img);
	}

	@Test
	public void testLoadImg() {
		Img img = imgDao.loadImg(1018);
		System.out.println(img.getImgAddress());
	}

	@Test
	public void testLoadMerImgByAddress() {
		Img img = imgDao.loadImgByAddress("sdfdsf");
		System.out.println(img.getImgId());
	}

	@Test
	public void testBrowseMerImg() {
		List<Img> l = imgDao.browseImg(1001, "mer_img_update_time", "desc");
		System.out.println(l);
	}

	@Test
	public void testBrowsePagingMerImg() {
		List<Img> l = imgDao.browsePagingImg(1003, 2, 10, "mer_img_update_time", "desc");
		System.out.println(l);
	}

}
