package com.nieyue.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.Manager;
import com.nieyue.dto.StateResult;
import com.nieyue.service.ManagerService;

/**
 * 管理控制类
 * @author yy
 *
 */
@Controller("managerController")
@RequestMapping("/manager")
public class ManagerController {
	@Resource
	private ManagerService managerService;
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping(value="/login",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Manager login(@ModelAttribute Manager manager,HttpSession session){
		Manager m = managerService.managerLogin(manager.getManagerPhone(), manager.getManagerPassword());
		if(m!=null&&!m.equals("")){
			session.setAttribute("manager", m);
		}
		return m;
	}
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping(value="/loginOut",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult loginOut(HttpSession session){
		if(session.getAttribute("manager")!=null&&!session.getAttribute("manager").equals("") ){
			session.removeAttribute("manager");
			
			return StateResult.getSuccess();
		}
		return StateResult.getFail();
	}
	/**
	 * 是否登录
	 * @return
	 */
	@RequestMapping(value="/isLogin",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Manager isLogin(HttpSession session){
		if(session.getAttribute("manager")!=null&&!session.getAttribute("manager").equals("") ){
			return (Manager) session.getAttribute("manager");
		}
		return null;
	}
	
	
}
