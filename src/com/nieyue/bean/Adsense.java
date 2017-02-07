package com.nieyue.bean;

import java.io.Serializable;
/**
 * 广告位类
 * @author yy
 *
 */
public class Adsense implements Serializable {
	
	private static final long serialVersionUID = 8198930199550185349L;
	/**
	 * 广告位id
	 */
	private Integer adsenseId;
	/**
	 * 广告位类型
	 */
	private Integer type;
	/**
	 * 广告位内容
	 */
	private String content;
	
	
	public Adsense() {
		super();
	}
	public Adsense(Integer adsenseId,Integer type, String content) {
		super();
		this.adsenseId = adsenseId;
		this.setType(type);
		this.content = content;
	}
	public Integer getAdsenseId() {
		return adsenseId;
	}
	public void setAdsenseId(Integer adsenseId) {
		this.adsenseId = adsenseId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
