package com.nieyue.test;

import java.io.IOException;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test5 {
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().replace("-",""));
	System.out.println((int)(Math.random()*9000+1000));
		
	String html = "<html><head><title>First parse</title></head>"
			  + "<body>"
			  + "<div class='content'><h1>标题</h1> </div>"
			  + "<div class='content'>"
			  + "<p>文章内容1</p>"
			  + "<p><img id ='img1' src='/uploaderPath/ueditor/image/20170206/1486372647807026947a.jpg'/></p>"
			  + "<p>Parsed HTML into a doc.</p>"
			  + "<p><img id ='img2' src='/uploaderPath/ueditor/image/20170206/1486372647807026947b.jpg'/></p>"
			  + "<p>Parsed文章内容3 HTML into a doc.</p>"
			  + "<p><img id ='img3' src='/uploaderPath/ueditor/image/20170206/1486372647807026947c.jpg'/></p>"
			  + " </div>"
			  + "</body></html>";
			
	Document doc = Jsoup.parse(html);
	System.out.println(doc.html());
	System.out.println("............................");
	System.out.println(doc.head());
	System.out.println("............................");
	System.out.println(doc.title());
	System.out.println("............................");
	System.out.println(doc.select(".content"));
	System.out.println("............................");
	System.out.println(doc.select("img"));
	System.out.println(doc.select("#img1"));
	for (int i = 0; i < doc.select("img").size(); i++) {
		doc.select("img").get(i).attr("src", "http://www.baidu.com"+doc.select("img").get(i).attr("src"));
		System.out.println(doc.select("img").get(i).attr("src"));
	}
	System.out.println(doc.toString());
	Document doc2;
	try {
		doc2 = Jsoup.connect("http://t.kejixun.com/4677").get();
		System.out.println("++++++++++++++++++++++++++");
		System.out.println(doc2.select(".news_title").text());
		Elements es = doc2.select(".news_info span");
		for (int i = 0; i < es.size(); i++) {
			 String ss = es.get(i).text();
			 System.out.println(ss);
		}
		System.out.println(doc2.select(".show_content").text().length());
		System.out.println("---------------------------------");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Document doc3;
	try {
		doc3 = Jsoup.connect("http://t.kejixun.com/4677").get();
		System.out.println("++++++++++++++++++++++++++");
		System.out.println(doc3.select(".news_title").text());
		Elements es = doc3.select(".news_info span");
		for (int i = 0; i < es.size(); i++) {
			 String ss = es.get(i).text();
			 System.out.println(ss);
		}
		System.out.println(doc3.select(".show_content").text().length());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}
