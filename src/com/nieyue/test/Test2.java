package com.nieyue.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.nieyue.util.HttpClientUtil;

public class Test2 {
	public static void main(String[] args) throws Exception {
		String url="http://v.juhe.cn/toutiao/index?type=top&key=b675753dd615a663bfefadb4f3f0728d";
		String s = HttpClientUtil.doGet(url);
		JSONObject jo=JSONObject.fromObject(s);
		 JSONObject result = jo.getJSONObject("result");
		 JSONArray ja = result.getJSONArray("data");
		for (int i = 0; i < ja.size(); i++) {
			 JSONObject news = (JSONObject) ja.get(i);
			 //System.out.println(news);
			 System.out.println(news.get("title"));
			 System.out.println(news.get("date"));
			 System.out.println(news.get("author_name"));
			 System.out.println(news.get("thumbnail_pic_s"));
			 System.out.println(news.get("thumbnail_pic_s02"));
			 System.out.println(news.get("thumbnail_pic_s03"));
			 System.out.println(news.get("url"));
			 System.out.println(news.get("uniquekey"));
			 System.out.println(news.get("type"));
			 System.out.println(news.get("realtype"));
			 
		}
	}
}

