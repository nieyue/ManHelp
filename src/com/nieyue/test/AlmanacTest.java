package com.nieyue.test;

import java.util.Calendar;
import java.util.Date;

public class AlmanacTest {
public static void main(String[] args) {
	Date d1 = new Date("1970"+"/01"+"/1 22:44:33");
	System.out.println(d1.toLocaleString());
	System.out.println(d1 instanceof Date);
	Date td=new Date();
	int year = Calendar.getInstance().get(Calendar.YEAR);
	int month = Calendar.getInstance().get(Calendar.MONTH)+1;
	int day = Calendar.getInstance().get(Calendar.DATE);
	int day2 = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	int day3= Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	int day4= Calendar.getInstance().get(Calendar.DAY_OF_WEEK_IN_MONTH);
	int day5= Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
	int day6= Calendar.getInstance().get(Calendar.MONDAY);
	int day7= Calendar.getInstance().get(Calendar.WEDNESDAY);
	int day8= Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
	System.out.println(td.toLocaleString());
	System.out.println(year);
	System.out.println(year + "-" +month+ "-"+day);
	System.out.println(year + "-" +month+ "-"+day2);
	System.out.println(day3);
	System.out.println(day4);
	System.out.println(day5);
	System.out.println(day6);
	System.out.println(day7);
	System.out.println(day8);
	Calendar c = Calendar.getInstance();
	c.setTime(d1);
	System.out.println(c.get(Calendar.YEAR));
	
}
}
