package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.News;
/**
 * 新闻接口
 * @author yy
 *
 */
public interface NewsDao {
	/** 新增新闻 */	
	public boolean addNews(News news) ;	
	/** 删除新闻 */	
	public boolean delNews(Integer newsId) ;
	/** 删除重复新闻 */	
	public boolean delNewsReview() ;
	/** 更新新闻 */	
	public boolean updateNews(News news);
	/** 装载新闻 */	
	public News loadNews(Integer newsId);	
	/** 根据类别浏览新闻 */
	public List<News> browseNews(@Param("type")String type,@Param("orderName")String orderName,@Param("orderWay")String orderWay);
	/** 分页新闻 */
	public List<News> browsePagingNews(@Param("type")String type,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;
	/** 随机查询置顶新闻 */
	public List<News> browseFixedRecommendRandomNews(@Param("pageSize")int pageSize,@Param("fixedRecommend")int fixedRecommend);
	/** 随机查询推荐新闻 */
	public List<News> browseRandomRecommendNews(@Param("pageSize")int pageSize,@Param("isRecommend")int isRecommend);
	/** 查询所有类型 去空 去重*/
	public List<String> browseTypeNews();
}
