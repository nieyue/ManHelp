package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.Almanac;
/**
 * 黄历接口
 * @author yy
 *
 */
public interface AlmanacDao {
	/** 新增黄历 */	
	public boolean addAlmanac(Almanac almanac) ;	
	/** 删除指定的黄历*/	
	public boolean delAlmanac(Integer almanacId) ;	
	/** 更新黄历*/	
	public boolean updateAlmanac(Almanac almanac);
	/** 装载指定的黄历 */	
	public Almanac loadAlmanac(Integer almanacId) ;	
	/** 根据时间查询黄历 */	
	public Almanac loadAlmanacByDate(@Param("y")int y,@Param("m")int m,@Param("d")int d) ;	
	/** 浏览黄历 */
	public List<Almanac> browseAlmanac(@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;	
	/** 分页浏览黄历 */
	public List<Almanac> browsePagingAlmanac(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;
	
}
