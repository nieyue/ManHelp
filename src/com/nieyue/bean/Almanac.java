package com.nieyue.bean;

import java.io.Serializable;
/**
 * 黄历类
 * @author yy
 *
 */
public class Almanac implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 黄历id
	 */
	private Integer almanacId;
	/**
	 * 年
	 */
	private Integer y;
	/**
	 * 月
	 */
	private Integer m;
	/**
	 * 日
	 */
	private Integer d;
	/**
	 * 宜
	 */
	private String yi;
	/**
	 * 忌
	 */
	private String ji;
	public Integer getAlmanacId() {
		return almanacId;
	}
	public void setAlmanacId(Integer almanacId) {
		this.almanacId = almanacId;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getM() {
		return m;
	}
	public void setM(Integer m) {
		this.m = m;
	}
	public Integer getD() {
		return d;
	}
	public void setD(Integer d) {
		this.d = d;
	}
	public String getYi() {
		return yi;
	}
	public void setYi(String yi) {
		this.yi = yi;
	}
	public String getJi() {
		return ji;
	}
	public void setJi(String ji) {
		this.ji = ji;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Almanac(Integer almanacId, Integer y, Integer m, Integer d, String yi, String ji) {
		super();
		this.almanacId = almanacId;
		this.y = y;
		this.m = m;
		this.d = d;
		this.yi = yi;
		this.ji = ji;
	}
	public Almanac() {
		super();
	}

	
}
