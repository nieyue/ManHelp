package com.nieyue.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.News;
import com.nieyue.comments.MyJoup;
import com.nieyue.dto.StateResult;
import com.nieyue.service.NewsService;

/**
 * 新闻控制类
 * @author yy
 *
 */
@Controller("newsController")
@RequestMapping("/news")
public class NewsController {
	@Resource
	private NewsService newsService;
	
	/**
	 * 分页浏览所有新闻
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<News> browsePagingNews(
			@RequestParam(value="pageNum",defaultValue="0",required=false)int pageNum,@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="type",defaultValue="首页",required=false) String type,
			@RequestParam(value="orderName",required=false,defaultValue="news_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="asc") String orderWay,HttpSession session)  {
			List<News> list = new ArrayList<News>();
			if(pageNum==0 ||pageSize==0){//查询所有
				list= newsService.browseNews(type, orderName, orderWay);
				return list;
			}
			list= newsService.browsePagingNews(type,pageNum, pageSize, orderName, orderWay);
			return list;
	}
	/**
	 * 随机浏览推荐新闻
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list/random/isRecommend", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<News> browseRandomRecommendNews(
			@RequestParam(value="pageSize",defaultValue="5",required=false) int pageSize,
			HttpSession session)  {
		List<News> list = new ArrayList<News>();
			list= newsService.browseRandomRecommendNews(pageSize,1);
		return list;
	}
	/**
	 * 浏览置顶新闻
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list/random/fixedRecommend", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<News> browseFixedRecommendRandomNews(
			@RequestParam(value="pageSize",defaultValue="3",required=false) int pageSize,
			HttpSession session)  {
		List<News> list = new ArrayList<News>();
		list= newsService.browseFixedRecommendRandomNews(pageSize,1);
		return list;
	}
	/**
	 * 新闻修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateNews(@ModelAttribute News news,HttpSession session)  {
		boolean um = newsService.updateNews(news);
		return StateResult.getSR(um);
	}
	/**
	 * 新闻增加
	 * @return
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addNews(@ModelAttribute News news, HttpSession session)  {
		Document doc = Jsoup.parse(news.getContent());
		if(!doc.select("img").equals(new Elements())){
			news.setImgAddress(doc.select("img").get(0).attr("src"));
		}
		boolean am = newsService.addNews(news);
		return StateResult.getSR(am);
	}
	
	/**
	 * 新闻抓取
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/grab", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult grabNews(@RequestParam(value="url")String url,@RequestParam(value="params")String params) throws Exception  {
		boolean b = false;
		News news;
		JSONObject p = JSONObject.fromObject(params);
		String link=p.getString("link");
		String title=p.getString("title");
		String time=p.getString("time");
		String type=p.getString("type");
		String img_address=p.getString("img_address");
		String content=p.getString("content");
		try {
				List<News> l = MyJoup.getNewsLink(url,link, title,
				time, type, img_address, content);
				for (int i = 0; i < l.size(); i++) {
					news=l.get(i);
					b=newsService.addNews(news);
				}
			newsService.delNewsReview();//去重
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return StateResult.getSR(b);
	}
	/**
	 * 东方新闻抓取
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/dfgrab", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult dfgrabNews(@RequestParam(value="url")String url,@RequestParam(value="content")String content) throws Exception  {
		boolean b = false;
		News news;
		try {
			List<News> l = MyJoup.getDFNewsDetails(url, content);
			for (int i = 0; i < l.size(); i++) {
				news=l.get(i);
				b=newsService.addNews(news);
			}
			newsService.delNewsReview();//去重
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return StateResult.getSR(b);
	}
	/**
	 * 新闻去重删除
	 * @return
	 */
	@RequestMapping(value = "/delete/review", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delNewsReview()  {
		boolean dm = newsService.delNewsReview();
		return StateResult.getSR(dm);
	}
	/**
	 * 新闻删除
	 * @return
	 */
	@RequestMapping(value = "/{newsId}/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delNews(@PathVariable("newsId") Integer newsId,HttpSession session)  {
		boolean dm = newsService.delNews(newsId);
		return StateResult.getSR(dm);
	}
	
	/**
	 * 单个新闻加载
	 * @return
	 */
	@RequestMapping(value = "/{newsId}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody News loadMer(@PathVariable("newsId") Integer newsId,HttpSession session)  {
		News news=new News();
		news = newsService.loadNews(newsId);
		return news;
	}
	
	
}
