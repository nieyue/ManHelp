package com.nieyue.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.Adsense;
import com.nieyue.dto.StateResult;
import com.nieyue.service.AdsenseService;

/**
 * 广告位控制类
 * @author yy
 *
 */
@Controller("adsenseController")
@RequestMapping("/adsense")
public class AdsenseController {
	@Resource
	private AdsenseService adsenseService;
	
	
	/**
	 * 浏览所有广告位
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Adsense> browseAdsense(HttpSession session)  {
		List<Adsense> list = new ArrayList<Adsense>();
			list= adsenseService.browseAdsense();
		return list;
	}
	/**
	 * 根据类型浏览所有广告位
	 * @return
	 */
	@RequestMapping(value = "/list/{type}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Adsense> browseAdsenseByType(@PathVariable("type") Integer type,HttpSession session)  {
		List<Adsense> list = new ArrayList<Adsense>();
		list= adsenseService.browseAdsenseByType(type);
		return list;
	}
	/**
	 * 广告位修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateAdsense(@ModelAttribute Adsense adsense,HttpSession session)  {
		boolean um = adsenseService.updateAdsense(adsense);
		return StateResult.getSR(um);
	}
	/**
	 * 广告位增加
	 * @return
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addAdsense(@ModelAttribute Adsense adsense, HttpSession session)  {
		boolean am =adsenseService.addAdsense(adsense);
		return StateResult.getSR(am);
	}
	
	/**
	 * 广告位删除
	 * @return
	 */
	@RequestMapping(value = "/{adsenseId}/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delAdsense(@PathVariable("adsenseId") Integer adsenseId,HttpSession session)  {
		boolean dm = adsenseService.delAdsense(adsenseId);
		return StateResult.getSR(dm);
	}
	
	/**
	 * 单个广告位加载
	 * @return
	 */
	@RequestMapping(value = "/{adsenseId}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Adsense loadAdsense(@PathVariable("adsenseId") Integer adsenseId,HttpSession session)  {
		Adsense adsense=new Adsense();
		adsense = adsenseService.loadAdsense(adsenseId);
		return adsense;
	}
	
	
}
