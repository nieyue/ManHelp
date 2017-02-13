package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.News;
import com.nieyue.dao.NewsDao;
import com.nieyue.service.NewsService;

/**
 * 新闻业务实现类
 * @author Administrator
 *
 */
@Service
public class NewsServiceImpl implements NewsService {
	@Resource
	NewsDao newsDao;
	/**
	 * 增加新闻
	 * @param 
	 */
	@Override
	public boolean addNews(News news) {
		boolean b = newsDao.addNews(news);
		return b;
	}
	/**
	 *删除新闻
	 * @param 
	 */
	@Override
	public boolean delNews(Integer newsId) {
		boolean b = newsDao.delNews(newsId);
		return b;
	}
	/**
	 * 更新新闻
	 * @param 
	 */
	@Override
	public boolean updateNews(News news) {
		boolean b = newsDao.updateNews(news);
		return b;
	}
	/**
	 * 加载新闻
	 * @param 
	 */
	@Override
	public News loadNews(Integer newsId) {
		News b = newsDao.loadNews(newsId);
		return b;
	}
	/**
	 * 浏览新闻
	 * @param 
	 */
	@Override
	public List<News> browseNews(String type, String orderName, String orderWay) {
		if(type.equals("首页")){
			type=null;
		}
		List<News> l = newsDao.browseNews(type, orderName, orderWay);
		return l;
	}
	/**
	 * 分页浏览新闻
	 * @param 
	 */
	@Override
	public List<News> browsePagingNews(String type, int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		if(type.equals("首页")){
			type=null;
		}
		List<News> l = newsDao.browsePagingNews(type, pageNum-1, pageSize, orderName, orderWay);
		return l;
	}
	/** 删除重复新闻 */	
	@Override
	public boolean delNewsReview() {
		boolean b = newsDao.delNewsReview();
		return b;
	}
	
	/** 随机查询置顶新闻 */
	@Override
	public List<News> browseFixedRecommendRandomNews(int pageSize,
			int fixedRecommend) {
		List<News> l = newsDao.browseFixedRecommendRandomNews(pageSize,fixedRecommend);
		return l;
	}
	/** 随机查询推荐新闻 */
	@Override
	public List<News> browseRandomRecommendNews(int pageSize, int isRecommend) {
		List<News> l = newsDao.browseRandomRecommendNews(pageSize,isRecommend);
		return l;
	}
	@Override
	public List<String> browseTypeNews() {
		List<String> tl = newsDao.browseTypeNews();
		return tl;
	}
	
}
