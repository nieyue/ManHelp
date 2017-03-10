package com.nieyue.dto;

import java.util.ArrayList;
import java.util.List;

import com.nieyue.bean.Img;
import com.nieyue.bean.News;
/**
 * 新闻DTO类
 * @author yy
 *
 */
public class NewsDTO  {
	
	private Integer code;
	private String msg;
	private News news;
	private List<Img> imgList=new ArrayList<Img>();
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public NewsDTO(Integer code, String msg, News news, List<Img> imgList) {
		super();
		this.code = code;
		this.msg = msg;
		this.news = news;
		this.imgList = imgList;
	}
	public NewsDTO() {
		super();
		setCode(200);
		setMsg("成功");
	}
	public List<Img> getImgList() {
		return imgList;
	}
	public void setImgList(List<Img> imgList) {
		this.imgList = imgList;
	}
	@Override
	public String toString() {
		return "NewsDTO [code=" + code + ", msg=" + msg + ", news=" + news + ", imgList=" + imgList + "]";
	}
	
	
}
