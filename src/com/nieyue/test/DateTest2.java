package com.nieyue.test;

import java.io.Serializable;

public class DateTest2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String updateDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public DateTest2(String name, String updateDate) {
		super();
		this.name = name;
		this.updateDate = updateDate;
	}
	public DateTest2() {
		super();
	}
	@Override
	public String toString() {
		return "DateTest2 [name=" + name + ", updateDate=" + updateDate + "]";
	}
	
}
	