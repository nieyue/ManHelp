package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.News;
/**
 * 新闻接口
 * @author yy
 *
 */
public interface NewsService {
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
	public List<News> browseNews(String type,String orderName,String orderWay);
	/** 分页新闻 */
	public List<News> browsePagingNews(String type,int pageNum,int pageSize,String orderName,String orderWay) ;
	/** 随机查询置顶新闻 */
	public List<News> browseFixedRecommendRandomNews(int pageSize,int fixedRecommend);
	/** 随机查询推荐新闻 */
	public List<News> browseRandomRecommendNews(int pageSize,int isRecommend);
	/** 查询所有类型 去空 去重*/
	public List<String> browseTypeNews();
}
