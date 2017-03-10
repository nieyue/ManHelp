package com.nieyue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.dto.NewsDTO;
import com.nieyue.dto.StateResult;

/**
 * 统一异常处理
 * @author yy
 *
 */
@Controller("exceptionController")
@RequestMapping("/exception")
public class ExceptionController {
	/**
	 * 普通异常
	 * @return
	 */
	@RequestMapping(value="/fail",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult test2(){
		return StateResult.getFail();
		
	}
	/**
	 * SellerSession
	 * @return
	 */
	@RequestMapping(value="/sellerSession",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult SellerSession(){
		return StateResult.getSlefSR(40001, "没有权限");
		
	}

	/**
	 * newsDTO
	 * @return
	 */
	@RequestMapping(value="/newsList/test",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody NewsDTO newsList( NewsDTO newsDTO){
		
		System.out.println("code= "+newsDTO.getCode());
		System.out.println("msg= "+newsDTO.getMsg());
		System.out.println("news= "+newsDTO.getNews());
		System.out.println("imglist= "+newsDTO.getImgList());
		for (int i = 0; i < newsDTO.getImgList().size(); i++) {
			System.out.println("address= "+newsDTO.getImgList().get(i).getImgAddress());
		}
		return newsDTO;
		
	}
	/**
	 * newsDTO
	 * @request code=2323&msg=22&news.newsId=1111&imgList[0].imgAddress=222222&imgList[1].imgAddress=3333&imgList[2].imgAddress=4444
	 * @return
	 */
	@RequestMapping(value="/newsList/attr",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody NewsDTO newsListAttr(@ModelAttribute NewsDTO newsDTO){
		
		System.out.println("code= "+newsDTO.getCode());
		System.out.println("msg= "+newsDTO.getMsg());
		System.out.println("news= "+newsDTO.getNews());
		System.out.println("imglist= "+newsDTO.getImgList());
		for (int i = 0; i < newsDTO.getImgList().size(); i++) {
			System.out.println("address= "+newsDTO.getImgList().get(i).getImgAddress());
		}
		return newsDTO;
		
	}
	/**
	 * newsDTO
	 * @return
	 */
	@RequestMapping(value="/newsList/body",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody NewsDTO newsListAttrbody(@RequestBody NewsDTO newsDTO){
		
		System.out.println("code= "+newsDTO.getCode());
		System.out.println("msg= "+newsDTO.getMsg());
		System.out.println("news= "+newsDTO.getNews());
		System.out.println("imglist= "+newsDTO.getImgList());
		for (int i = 0; i < newsDTO.getImgList().size(); i++) {
			System.out.println("address= "+newsDTO.getImgList().get(i).getImgAddress());
		}
		return newsDTO;
		
	}

}
