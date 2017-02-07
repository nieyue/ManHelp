package com.nieyue.service.impl.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.nieyue.bean.Img;
import com.nieyue.service.ImgService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring-dao.xml","classpath:config/spring-service.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class ImgServiceImplTest {
	@Resource
	ImgService imgService;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddImg() {
		for (int j = 0; j < 10; j++) {
			Img mi=new Img();
			mi.setImgId(1003);
			if(Math.random()*10>5){
				mi.setImgId(1004);
			}
			mi.setImgAddress("/resources/sellerUpload/7/黑茶/百两茶/百两茶_"+j+".jpg");
			imgService.addImg(mi);
		}
	}

	@Test
	public void testDelImg() {
		imgService.delImg(1029);
	}

	@Test
	public void testUpdateMerImg() {
		Img img = imgService.loadImg(1028);
		img.setImgAddress("sdfdsf1");
		imgService.updateImg(img);
	}

	@Test
	public void testLoadMerImg() {
		Img merImg = imgService.loadImg(1028);
		System.out.println(merImg.getImgAddress());
	}

	@Test
	public void testBrowseMerImg() {
		List<Img> l = imgService.browseImg(1001, "mer_img_update_time", "desc");
		System.out.println(l);
	}

	@Test
	public void testBrowsePagingMerImg() {
		List<Img> l = imgService.browsePagingImg(1003, 0, -1, "mer_img_update_time", "desc");
		System.out.println(l);
	}

	@Test
	public void testLoadMerImgByAddress() {
		Img merImg = imgService.loadImgByAddress("sdfdsf1");
		System.out.println(merImg.getImgId());
	}

}
