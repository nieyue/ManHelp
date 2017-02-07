package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.Img;
/**
 * 新闻图片业务接口
 * @author yy
 *
 */
public interface ImgService {
	/** 新增新闻图片 */	
	public boolean addImg(Img img) ;	
	/** 删除指定的新闻 图片*/	
	public boolean delImg(Integer imgId) ;	
	/** 更新新闻 图片*/	
	public boolean updateImg(Img img);
	/** 装载指定的新闻图片 */	
	public Img loadImg(Integer imgId) ;	
	/** 图片地址查询商品图片 */	
	public Img loadImgByAddress(String imgAddress) ;	
	/** 浏览新闻图片 */
	public List<Img> browseImg(Integer newsId,String orderName,String orderWay) ;	
	/** 分页浏览新闻图片 */
	public List<Img> browsePagingImg(Integer newsId,int pageNum,int pageSize,String orderName,String orderWay) ;

}
