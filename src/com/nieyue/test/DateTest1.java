package com.nieyue.test;

import java.io.Serializable;
import java.util.Date;

public class DateTest1 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Date updateDate;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public DateTest1(String name, Date updateDate) {
		super();
		this.name = name;
		this.updateDate = updateDate;
	}
	public DateTest1() {
		super();
	}
	@Override
	public String toString() {
		return "DateTest1 [name=" + name + ", updateDate=" + updateDate + "]";
	}
	
	
}
