package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.Img;
import com.nieyue.dao.ImgDao;
import com.nieyue.service.ImgService;

/**
 * 新闻图片业务实现类
 * @author Administrator
 *
 */
@Service
public class ImgServiceImpl implements ImgService {
	@Resource
	ImgDao imgDao;

	/**
	 * 新增新闻图片
	 * @param img
	 */
	@Override
	public boolean addImg(Img img) {
		boolean b = imgDao.addImg(img);
		return b;
	}
	/**
	 * 删除指定的新闻图片
	 * @param imgId
	 */
	@Override
	public boolean delImg(Integer imgId) {
		boolean b = imgDao.delImg(imgId);
		return b;
	}
	/**
	 * 更新新闻图片
	 * @param img
	 */
	@Override
	public boolean updateImg(Img img) {
		boolean b = imgDao.updateImg(img);
		return b;
	}
	/**
	 * 装载指定的新闻图片
	 * @param merImg
	 */
	@Override
	public Img loadImg(Integer imgId) {
		Img img = imgDao.loadImg(imgId);
		return img;
	}
	
	/**
	 * 根据图片地址加载新闻图片
	 * @param merImg
	 */
	@Override
	public Img loadImgByAddress(String imgAddress) {
		Img img = imgDao.loadImgByAddress(imgAddress);
		return img;
	}
	/**
	 * 浏览新闻图片
	 * @param merImg
	 */
	@Override
	public List<Img> browseImg(Integer newsId, String orderName, String orderWay) {
		List<Img> l = imgDao.browseImg(newsId, orderName, orderWay);
		return l;
	}
	/**
	 * 分页浏览商品图片
	 * @param merImg
	 */
	@Override
	public List<Img> browsePagingImg(Integer newsId, int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<Img> l = imgDao.browsePagingImg(newsId,pageNum-1, pageSize, orderName, orderWay);
		return l;
	}

}
