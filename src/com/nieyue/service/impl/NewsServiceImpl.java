package com.nieyue.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.Img;
import com.nieyue.bean.News;
import com.nieyue.dao.ImgDao;
import com.nieyue.dao.NewsDao;
import com.nieyue.dto.NewsDTO;
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
	@Resource
	ImgDao imgDao;
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
	public List<News> browseFixedRecommendRandomNews(int pageNum,int pageSize,
			int fixedRecommend) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<News> l = newsDao.browseFixedRecommendRandomNews(pageNum-1,pageSize,fixedRecommend);
		return l;
	}
	/** 随机查询推荐新闻 */
	@Override
	public List<News> browseRandomRecommendNews(int pageSize, int isRecommend) {
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<News> l = newsDao.browseRandomRecommendNews(pageSize,isRecommend);
		return l;
	}
	@Override
	public List<String> browseTypeNews() {
		List<String> tl = newsDao.browseTypeNews();
		return tl;
	}
	@Override
	public List<News> browseRecommendNews(int pageNum, int pageSize, int isRecommend) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<News> l = newsDao.browseRecommendNews(pageNum-1,pageSize,isRecommend);
		return l;
	}
	@Override
	public List<News> browsePagingNewsByTitle(String title, int pageNum, int pageSize, String orderName,
			String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<News> l = newsDao.browsePagingNewsByTitle(title,pageNum-1,pageSize,orderName,orderWay);
		return l;
	}
	@Override
	public boolean addNewsDTO(NewsDTO newsDTO) {
		boolean b=false;
		News news = newsDTO.getNews();
		b = newsDao.addNews(news);
		List<Img> il = newsDTO.getImgList();
		for (int i = 0; i < il.size(); i++) {
			Img img = il.get(i);
			img.setNewsId(news.getNewsId());
			b=imgDao.addImg(img);
		}
		return b;
	}
	@Override
	public boolean updateNewsDTO(NewsDTO newsDTO) {
		boolean b=false;
		News news = newsDTO.getNews();
		b = newsDao.updateNews(news);
		List<Img> il = newsDTO.getImgList();
		for (int i = 0; i < il.size(); i++) {
			Img img = il.get(i);
			b=imgDao.updateImg(img);
		}
		return b;
	}
	@Override
	public NewsDTO loadNewsDTO(Integer newsId) {
		NewsDTO newsDTO=new NewsDTO();
		News news = newsDao.loadNews(newsId);
		newsDTO.setNews(news);
		List<Img> il = imgDao.browseImg(newsId, "number", "asc");
		newsDTO.setImgList(il);
		return newsDTO;
	}
	/**
	 * 浏览新闻DTO
	 * @param 
	 */
	@Override
	public List<NewsDTO> browseNewsDTO(String type, String orderName, String orderWay) {
		if(type.equals("首页")){
			type=null;
		}
		List<News> l = newsDao.browseNews(type, orderName, orderWay);
		List<NewsDTO> nl = new ArrayList<NewsDTO>();
		for (int i = 0; i < l.size(); i++) {
			News news = l.get(i);
			NewsDTO nnews = new NewsDTO();
			nnews.setNews(news);
			List<Img> il = imgDao.browseImg(news.getNewsId(), "number", "desc");
			nnews.setImgList(il);
			nl.add(nnews);
		}
		return nl;
	}
	@Override
	public List<NewsDTO> browsePagingNewsDTOByTitle(String title, int pageNum, int pageSize, String orderName,
			String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<News> l = newsDao.browsePagingNewsByTitle(title,pageNum-1,pageSize,orderName,orderWay);
		List<NewsDTO> nl = new ArrayList<NewsDTO>();
		for (int i = 0; i < l.size(); i++) {
			News news = l.get(i);
			NewsDTO nnews = new NewsDTO();
			nnews.setNews(news);
			List<Img> il = imgDao.browseImg(news.getNewsId(), "number", "desc");
			nnews.setImgList(il);
			nl.add(nnews);
		}
		return nl;
	}
	@Override
	public List<NewsDTO> browsePagingNewsDTO(String type, int pageNum, int pageSize, String orderName,
			String orderWay) {
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
		List<NewsDTO> nl = new ArrayList<NewsDTO>();
		for (int i = 0; i < l.size(); i++) {
			News news = l.get(i);
			NewsDTO nnews = new NewsDTO();
			nnews.setNews(news);
			List<Img> il = imgDao.browseImg(news.getNewsId(), "number", "desc");
			nnews.setImgList(il);
			nl.add(nnews);
		}
		return nl;
	}
	@Override
	public List<NewsDTO> browseFixedRecommendRandomNewsDTO(int pageNum, int pageSize, int fixedRecommend) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<News> l = newsDao.browseFixedRecommendRandomNews(pageNum-1,pageSize,fixedRecommend);
		List<NewsDTO> nl = new ArrayList<NewsDTO>();
		for (int i = 0; i < l.size(); i++) {
			News news = l.get(i);
			NewsDTO nnews = new NewsDTO();
			nnews.setNews(news);
			List<Img> il = imgDao.browseImg(news.getNewsId(), "number", "desc");
			nnews.setImgList(il);
			nl.add(nnews);
		}
		return nl;
	}
	@Override
	public List<NewsDTO> browseRecommendNewsDTO(int pageNum, int pageSize, int isRecommend) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<News> l = newsDao.browseRecommendNews(pageNum-1,pageSize,isRecommend);
		List<NewsDTO> nl = new ArrayList<NewsDTO>();
		for (int i = 0; i < l.size(); i++) {
			News news = l.get(i);
			NewsDTO nnews = new NewsDTO();
			nnews.setNews(news);
			List<Img> il = imgDao.browseImg(news.getNewsId(), "number", "desc");
			nnews.setImgList(il);
			nl.add(nnews);
		}
		return nl;
	}
	@Override
	public List<NewsDTO> browseRandomRecommendNewsDTO(int pageSize, int isRecommend) {
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<News> l = newsDao.browseRandomRecommendNews(pageSize,isRecommend);
		List<NewsDTO> nl = new ArrayList<NewsDTO>();
		for (int i = 0; i < l.size(); i++) {
			News news = l.get(i);
			NewsDTO nnews = new NewsDTO();
			nnews.setNews(news);
			List<Img> il = imgDao.browseImg(news.getNewsId(), "number", "desc");
			nnews.setImgList(il);
			nl.add(nnews);
		}
		return nl;
	}
	
}
