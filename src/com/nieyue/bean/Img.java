package com.nieyue.bean;

import java.io.Serializable;
/**
 * 图片类
 * @author yy
 *
 */
public class Img implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 图片id
	 */
	private Integer imgId;
	/**
	 * 图片地址
	 */
	private String imgAddress;
	/**
	 * 新闻id
	 */
	private Integer newsId;
	public Img(Integer imgId, String imgAddress, Integer newsId) {
		super();
		this.imgId = imgId;
		this.imgAddress = imgAddress;
		this.newsId = newsId;
	}
	public Img() {
		super();
	}
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	public String getImgAddress() {
		return imgAddress;
	}
	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	
	
}
