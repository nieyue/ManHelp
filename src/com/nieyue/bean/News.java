package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 新闻类
 * @author yy
 *
 */
public class News implements Serializable {
	
	private static final long serialVersionUID = 8198930199550185349L;
	private Integer newsId;
	private String type;
	private String title;
	private Integer isRecommend;//是否推荐 默认否
	private Integer fixedRecommend;//是否置顶推荐 默认否
	private Date time;
	private String imgAddress;
	private String content;
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}
	public Integer getFixedRecommend() {
		return fixedRecommend;
	}
	public void setFixedRecommend(Integer fixedRecommend) {
		this.fixedRecommend = fixedRecommend;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getImgAddress() {
		return imgAddress;
	}
	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public News(Integer newsId, String type, String title, Integer isRecommend,
			Integer fixedRecommend, Date time, String imgAddress, String content) {
		super();
		this.newsId = newsId;
		this.type = type;
		this.title = title;
		this.isRecommend = isRecommend;
		this.fixedRecommend = fixedRecommend;
		this.time = time;
		this.imgAddress = imgAddress;
		this.content = content;
	}
	public News() {
		super();
	}
	
	
	
}
