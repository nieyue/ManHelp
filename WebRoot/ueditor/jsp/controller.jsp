<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	
	String rootPath = application.getRealPath( "/" );
	String uploaderPath=request.getParameter("uploaderPath");
	System.out.println("uploaderPath="+request.getParameter("uploaderPath"));
	//String rootPath = "c:/";
	//String action = request.getParameter("action");
	String result = new ActionEnter( request,uploaderPath, rootPath ).exec();
	 /*  if( action!=null && 
	   (action.equals("listfile") || action.equals("listimage") ) ){
	    rootPath = rootPath.replace("\\", "/");
	    result = result.replaceAll(rootPath, "");
	}   */
	out.write( result );
	
%>