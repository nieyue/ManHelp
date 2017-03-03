package com.nieyue.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.util.MyThirdAPIUtil;

/**
 * api控制类
 * @author yy
 *
 */
@Controller("apiController")
@RequestMapping("/thirdapi")
public class ApiController {
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
			@RequestParam(value="cityAddress",defaultValue="101010100",required=false)String cityAddress,
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
		String result = "";
		try {
			String cityAddress = MyThirdAPIUtil.getCity(ip);
			if(MyThirdAPIUtil.getXinLangTianQi(cityAddress)!=null && !MyThirdAPIUtil.getXinLangTianQi(cityAddress).equals("")){
				result=MyThirdAPIUtil.getXinLangTianQi(cityAddress);
			}else if(MyThirdAPIUtil.getQiXiangJuTianQi(cityAddress)!=null && !MyThirdAPIUtil.getQiXiangJuTianQi(cityAddress).equals("")){
				result=MyThirdAPIUtil.getXinLangTianQi(cityAddress);
				
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return result;
		}
	}
}
