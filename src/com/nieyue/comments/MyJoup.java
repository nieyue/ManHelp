package com.nieyue.comments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.nieyue.bean.News;
import com.nieyue.service.ImgService;
import com.nieyue.service.NewsService;
import com.nieyue.util.DateUtil;
import com.nieyue.util.HttpClientUtil;

/**
 * 网页数据抓取
 * @author yy
 *
 */
@Component
public class MyJoup {
	@Resource
	NewsService newsService;
	@Resource
	ImgService imgService;
	/**
	 * 获取新闻文章详情
	 * @return
	 * @throws Exception 
	 */
	public static List<News> getNewsLink(String url,String link,String title,String time,String type,String imgAddress,String content) throws Exception{
		List<News> l=new ArrayList<News>();
		Document doc;
	try {
		//doc = Jsoup.connect(url).get();
		doc=Jsoup.parse(HttpClientUtil.doGet(url));
		System.out.println(doc);
		for (int i = 0; i < doc.select(title).size(); i++) {
			News news=new News();
			news.setTitle(doc.select(title).get(i).text());//设置标题
			//news.setTime(DateUtil.parseSimpleDate(doc.select(time).get(i).text()));//设置时间
			if(!Pattern.compile("[\\u4E00-\\u9FBF]+").matcher(type.trim()).find()){
				news.setType(doc.select(type).get(i).text());//设置类型
			}else{
				news.setType(type);//设置类型
			}
			/*if(!doc.select(imgAddress).get(i).equals(new Elements().get(i))){
				news.setImgAddress(doc.select(imgAddress).get(i).attr("src"));
			}*/
			
			String url2 = doc.select(link).get(i).attr("href");//获取链接
			//Document doc2 = Jsoup.connect(url2).get();
			Document doc2=Jsoup.parse(HttpClientUtil.doGet(url2));
			if(!doc2.select(imgAddress).equals(new Elements())){
				if(doc2.select(imgAddress).first().attr("data-pic")!=null&&!doc2.select(imgAddress).first().attr("data-pic").isEmpty()){
					news.setImgAddress(doc2.select(imgAddress).first().attr("data-pic"));
					
				}else if(doc2.select(imgAddress).first().attr("data-src")!=null&&!doc2.select(imgAddress).first().attr("data-src").isEmpty()){
					news.setImgAddress(doc2.select(imgAddress).first().attr("data-src"));
					
				}else{
				news.setImgAddress(doc2.select(imgAddress).first().attr("src"));
				}
			}
			 String t = doc2.select(time).text();
			if(t.length()==19){
				news.setTime(DateUtil.parseDate(t));//设置时间
			}else if(t.length()==16){
				news.setTime(DateUtil.parseDate2(t));//设置时间
			}else if(t.length()==13){
				news.setTime(DateUtil.parseDate3(t));//设置时间
			}else if(t.length()==10){
				news.setTime(DateUtil.parseDate4(t));//设置时间
			}
			news.setContent(doc2.select(content).toString());//设置内容
			if(!news.getContent().isEmpty()&&news.getContent()!=null){
				l.add(news);
			}
			
		}
		return l;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return l;
	}
	/**
	 * 获取新闻文章详情
	 * @return
	 * @throws Exception 
	 */
	public static News getNewsDetails(String url,String title,String time,String type,String imgAddress,String content) throws Exception{
		News news=new News();
		Document doc;
	try {
		//doc = Jsoup.connect(url).get();
		 doc=Jsoup.parse(HttpClientUtil.doGet(url));
		news.setTitle(doc.select(title).text());
		//System.out.println(doc.select(title).text());
		Elements es = doc.select(time);
		System.out.println(es.text());
		//news.setTime(DateUtil.parseSelfDate(es.text(),"yyyy-MM-dd HH:mm"));
		if(!doc.select(imgAddress).equals(new Elements())){
		news.setImgAddress(doc.select(imgAddress).first().attr("src"));
		}
		//System.out.println(es.text());
		Elements es2 = doc.select(type);
		news.setType(es2.text());
		//System.out.println(es2.text());
		news.setContent(doc.select(content).toString());
		//System.out.println(doc.select(content));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(news.getTitle());
	System.out.println(news.getTime());
	System.out.println(news.getType());
	System.out.println(news.getContent());
		return news;
	}
	/**
	 * 东方直接获取 新闻文章详情
	 * @return
	 * @throws Exception 
	 */
	public static List<News> getDFNewsDetails(String url,String content) throws Exception{
		List<News> ll=new ArrayList<News>();
		String s = HttpClientUtil.doGet(url);
		JSONObject jo=JSONObject.fromObject(s);
		 JSONObject result = jo.getJSONObject("result");
		 JSONArray ja = result.getJSONArray("data");
		for (int i = 0; i < ja.size(); i++) {
			News news=new News();
			 JSONObject newsjosn = (JSONObject) ja.get(i);
			 System.out.println(newsjosn.get("title"));
			 news.setTitle(newsjosn.get("title").toString());
			 news.setTime(DateUtil.parseSelfDate(newsjosn.get("date").toString(),"yyyy-MM-dd HH:mm"));
			 news.setImgAddress(newsjosn.get("thumbnail_pic_s").toString());
			 news.setType(newsjosn.get("realtype").toString());
			 //得到详情页
			 Document doc2=Jsoup.parse(HttpClientUtil.doGet(newsjosn.get("url").toString()));
			 news.setContent(doc2.select(content).toString());//设置内容
			 ll.add(news);
		}
			return ll;
	}
	
	public static void main(String[] args) throws Exception {
		//getNewsDetails("http://t.kejixun.com/4677",".news_title",".news_info span:first-child",".news_info span:last-child",".show_content");
		/*List<News> l = getNewsLink("http://t.kejixun.com/list/6",".clearfix a",".clearfix h3",".news_info span:first-child",".clearfix .item_info span:last-child",".clearfix img",".show_content");
		for (int i = 0; i < l.size(); i++) {
			News n = l.get(i);
			System.out.println(n.getTitle());
			System.out.println(n.getType());
			System.out.println(n.getTime());
			System.out.println(n.getImgAddress());
			System.out.println(n.getContent());
		}*/
		
		String link=".list ul li a";
		String title=".list ul li a h2";
		String time="div.primary .meta .time";
		String type="八卦";
		String img_address="div.content img:first-child";
		String content="div.content";
		String shehui="http://xw.qq.com/m/shehui/";//社会
		String junshi="http://xw.qq.com/m/mil/";//军事
		String yule="http://xw.qq.com/m/ent/";//娱乐
		String tiyu="http://xw.qq.com/m/sports/";//体育
		String nba="http://xw.qq.com/m/nba/";//nba
		String keji="http://xw.qq.com/m/tech/";//科技
		String shuma="http://xw.qq.com/m/digi/";//数码
		String shishang="http://xw.qq.com/m/fashion/";//时尚
		String xingzuo="http://xw.qq.com/m/astro/";//星座
	List<News> l2 = getNewsLink(xingzuo,
			link, title, time, type, img_address, content);
	for (int i = 0; i < l2.size(); i++) {
		News n = l2.get(i);
		System.out.println(n.getTitle());
		System.out.println(n.getType());
		System.out.println(n.getTime());
		System.out.println(n.getImgAddress());
		System.out.println(n.getContent());
	}
				
	}
}
