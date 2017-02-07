package com.nieyue.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.nieyue.dto.StateResult;
/**
 * DefaultHandlerExceptionResolver
 * @author yy
 *
 */
public class MyDefaultHandlerExceptionResolver extends
		DefaultHandlerExceptionResolver {
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
        // 根据不同错误转向不同页面  
        if(ex instanceof MySellerSessionException) {  
            return new ModelAndView("forward:/exception/sellerSession", "123456",StateResult.getSlefSR(5000, "sdfdsf1")) ;
        }else {  
        	return new ModelAndView("forward:/exception/fail", "123456",StateResult.getSlefSR(5000, "sdfdsf1")) ;
        }  
	}
}
