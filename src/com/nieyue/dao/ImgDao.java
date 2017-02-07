package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.Img;
/**
 * 新闻图片接口
 * @author yy
 *
 */
public interface ImgDao {
	/** 新增新闻图片 */	
	public boolean addImg(Img img) ;	
	/** 删除指定的新闻 图片*/	
	public boolean delImg(Integer imgId) ;	
	/** 更新新闻 图片*/	
	public boolean updateImg(Img img);
	/** 装载指定的新闻图片 */	
	public Img loadImg(Integer imgId) ;	
	/** 图片地址查询新闻图片 */	
	public Img loadImgByAddress(String imgAddress) ;	
	/** 浏览新闻图片 */
	public List<Img> browseImg(@Param("newsId")Integer newsId,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;	
	/** 分页浏览新闻图片 */
	public List<Img> browsePagingImg(@Param("newsId")Integer newsId,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;
	
}
