package com.nieyue.controller;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.Almanac;
import com.nieyue.service.AlmanacService;
import com.nieyue.util.MyThirdAPIUtil;

/**
 * api控制类
 * @author yy
 *
 */
@Controller("apiController")
@RequestMapping("/thirdapi")
public class ApiController {
	@Resource
	AlmanacService almanacService;
	/**
	 * 根据地名获取新浪天气
	 * @author Administrator
	 * @param cityAddress 如：常德
	 *
	 */
	@RequestMapping(value="/xinlangweather",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String getXinLangTianQi(
			@RequestParam(value="cityAddress",defaultValue="北京",required=false)String cityAddress,
			HttpSession session){
		String result = "";
		try {
			result = MyThirdAPIUtil.getXinLangTianQi(cityAddress);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return result;
		}
	}
	
	/**
	 * 根据地名编号获取气象局天气
	 * @author Administrator
	 * @param cityAddressNumber 如：101010100
	 */
	@RequestMapping(value="/qixiangjuweather",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String getQiXiangJuTianQi(
			@RequestParam(value="cityAddressNumber",defaultValue="101010100",required=false)String cityAddressNumber,
			HttpSession session){
		String result = "";
		try {
			result = MyThirdAPIUtil.getQiXiangJuTianQi(cityAddressNumber);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return result;
		}
	}
	
	/**
	 * 根据地名获取CDN天气
	 * @author Administrator
	 * @param cityAddress 如：常德
	 */
	@RequestMapping(value="/cdnweather",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String getCDNTianQi(
			@RequestParam(value="cityAddress",defaultValue="北京",required=false)String cityAddress,
			HttpSession session){
		String result = "";
		try {
			result = MyThirdAPIUtil.getCDNTianQi(cityAddress);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return result;
		}
	}

	/**
	 * 百度api,根据ip地址获取城市地名
	 * @author Administrator
	 * @param ip 如：110.52.6.0
	 * @return city 如 ：常德
	 */
	@RequestMapping(value="/city",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String getCity(
			@RequestParam(value="ip",defaultValue="110.52.6.0",required=false)String ip,
			HttpSession session){
			String cityAddress = "";
			try {
				cityAddress = MyThirdAPIUtil.getCity(ip);
				return cityAddress;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return cityAddress;
			}
	}
	/**
	 * 直接获取天气
	 * @author Administrator
	 */
	@RequestMapping(value="/weather",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String getWeather(
			HttpServletRequest request,
			HttpSession session){
		String result = "";
		try {
			String cityAddress = MyThirdAPIUtil.getCity("118.250.0.186");
			//String cityAddress = MyThirdAPIUtil.getCity(IPCountUtil.getIpAddr2(request));
			if(MyThirdAPIUtil.getCDNTianQi(cityAddress)!=null && !MyThirdAPIUtil.getCDNTianQi(cityAddress).equals("")){
				result=MyThirdAPIUtil.getCDNTianQi(cityAddress);
				
			}else if(MyThirdAPIUtil.getXinLangTianQi(cityAddress)!=null && !MyThirdAPIUtil.getXinLangTianQi(cityAddress).equals("")){
				result=MyThirdAPIUtil.getXinLangTianQi(cityAddress);
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return result;
		}
	}
	/**
	 * 获取当日黄历
	 * @author Administrator
	 */
	@RequestMapping(value="/almanac",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Almanac getAlmanac(
			@RequestParam(value="date",required=false)String date,
			HttpSession session){
		Almanac a=new Almanac();
		if(date!=null && !date.equals("") && new Date(date) instanceof Date){
			Date da = new Date(date);
			Calendar c = Calendar.getInstance();
			c.setTime(da);
			
			int y = c.get(Calendar.YEAR);
			int m = c.get(Calendar.MONTH)+1;
			int d = c.get(Calendar.DATE);
			 a = almanacService.loadAlmanacByDate(y, m, d);
			 return a;
		}else {
			 a=almanacService.loadAlmanacByDate(0, 0, 0);
		return a;
		}
		
}
}
