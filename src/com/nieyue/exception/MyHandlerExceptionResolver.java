package com.nieyue.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.nieyue.dto.StateResult;
/**
 * HandlerExceptionResolver自定义全局异常类
 * @author yy
 *
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
	        // 根据不同错误转向不同页面  
	        if(ex instanceof MySellerSessionException) {  
	            return new ModelAndView("forward:/exception/sellerSession","xml", StateResult.getSlefSR(50001, "请求错误"));  
	        }else {  
	            return new ModelAndView("forward:/exception/fail","xml", StateResult.getSlefSR(40001, "没权限"));  
	        }  
	}

}
