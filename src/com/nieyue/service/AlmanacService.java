package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.Almanac;

/**
 * 黄历逻辑接口
 * @author yy
 *
 */
public interface AlmanacService {
	/** 新增黄历 */	
	public boolean addAlmanac(Almanac almanac) ;	
	/** 删除指定的黄历*/	
	public boolean delAlmanac(Integer almanacId) ;	
	/** 更新黄历*/	
	public boolean updateAlmanac(Almanac almanac);
	/** 装载指定的黄历 */	
	public Almanac loadAlmanac(Integer almanacId) ;	
	/** 根据时间查询黄历 */	
	public Almanac loadAlmanacByDate(int y,int m,int d) ;	
	/** 浏览黄历 */
	public List<Almanac> browseAlmanac( String orderName, String orderWay) ;	
	/** 分页浏览黄历 */
	public List<Almanac> browsePagingAlmanac( int pageNum, int pageSize, String orderName,String orderWay) ;
	
}