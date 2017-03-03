package com.nieyue.test;

import java.io.Serializable;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.Date;

import com.nieyue.bean.News;
import com.nieyue.comments.MyBeanUtils;
import com.nieyue.dto.StateResult;
import com.nieyue.util.HttpClientUtil;

import net.sf.json.JSONObject;

public class Test3 implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public static void main(String[] args) throws Exception {
DateTest1 d1 = new DateTest1();
d1.setName("聂跃");
d1.setUpdateDate(new Date());
DateTest2 d2 = new DateTest2();
//d2.setName("聂跃");
//d2.setUpdateDate("2017-03-22 11:12:55")
MyBeanUtils.copyProperties(d2, d1,"yyyy-MM-dd HH:mm:ss");
System.out.println(d1.toString());
System.out.println(d2.toString());
//System.out.println(d1);
News nnn = new News();
StateResult sr = new StateResult();
System.out.println(JSONObject.fromObject(d1).toString());
//System.out.println(getXinLangTianQi());
//System.out.println(getQiXiangJuTianQi());
//System.out.println(getCDNTianQi());
System.out.println(getCity("110.52.6.0"));

}
public static String getXinLangTianQi() throws Exception{
	String xinlangtianqi="http://php.weather.sina.com.cn/iframe/index/w_cl.php?code=js&day=0&city=常德&dfc=1&charset=utf-8";
	String result = HttpClientUtil.doGet(xinlangtianqi);
	
	return result;
}
public static String getQiXiangJuTianQi() throws Exception{
	String xinlangtianqi="http://www.weather.com.cn/data/cityinfo/101010100.html";
	String result = HttpClientUtil.doGet(xinlangtianqi);
	
	return result;
}
 
public static String getCDNTianQi() throws Exception{
	String xinlangtianqi="http://wthrcdn.etouch.cn/weather_mini?city=长沙";
	String result = HttpClientUtil.doGet(xinlangtianqi);
	
	return result;
}

public static String getCity(String ip) throws Exception{
	String ak="U3unpKKLGNvoOO10vkkUfPd7Y5bnRpAV";
	String url="http://api.map.baidu.com/location/ip?ip="+ip+"&ak="+ak;
	String result = HttpClientUtil.doGet(url);
	Object content = JSONObject.fromObject(result).get("content");
	Object address_detail = JSONObject.fromObject(content).get("address_detail");
	String city = JSONObject.fromObject(address_detail).get("city").toString();
	if(city.indexOf("市")>-1){
		city=city.substring(0,city.indexOf("市"));
	}
	return city;
}

}
