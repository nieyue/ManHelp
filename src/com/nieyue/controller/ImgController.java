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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.Img;
import com.nieyue.dto.StateResult;
import com.nieyue.service.ImgService;

/**
 * 新闻图片控制类
 * @author yy
 *
 */
@Controller("imgController")
@RequestMapping("/img")
public class ImgController {
	@Resource
	private ImgService imgService;
	/**
	 * 分页浏览商家的获取所有新闻图片
	 * @param merStatus 上架1 下架0
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Img> browsePagingMer(
			@RequestParam(value="pageNum",defaultValue="0",required=false)int pageNum,@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="newsId",defaultValue="0",required=false) Integer newsId,
			@RequestParam(value="orderName",required=false,defaultValue="img_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="asc") String orderWay,HttpSession session)  {
			List<Img> list = new ArrayList<Img>();
			if(pageNum==0 ||pageSize==0){//查询所有
				list= imgService.browseImg(newsId, orderName,orderWay);
				return list;
			}
			list= imgService.browsePagingImg(pageNum, pageSize, newsId, orderName, orderWay);
			return list;
	}
	/**
	 * 新闻图片修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateImg(@ModelAttribute Img img,HttpSession session)  {
		boolean um =imgService.updateImg(img);
		return StateResult.getSR(um);
	}
	/**
	 * 新闻图片增加
	 * @return
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addImg(@ModelAttribute Img img, HttpSession session)  {
		boolean am = imgService.addImg(img);
		return StateResult.getSR(am);
	}
	/**
	 * 新闻图片删除
	 * @return
	 */
	@RequestMapping(value = "/{imgId}/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delImg(@PathVariable("imgId") Integer imgId,HttpSession session)  {
		boolean dm = imgService.delImg(imgId);
		return StateResult.getSR(dm);
	}
	
	/**
	 * 单个新闻图片加载
	 * @return
	 */
	@RequestMapping(value = "/{imgId}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Img loadMer(@PathVariable("imgId") Integer imgId,HttpSession session)  {
		Img img=new Img();
		img = imgService.loadImg(imgId);
		return img;
	}
	
}
