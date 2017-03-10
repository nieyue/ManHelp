package com.nieyue.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.Almanac;
import com.nieyue.dao.AlmanacDao;
import com.nieyue.service.AlmanacService;

/**
 * 黄历业务实现类
 * @author Administrator
 *
 */
@Service
public class AlmanacServiceImpl implements AlmanacService {
	@Resource
	AlmanacDao almanacDao;

	/**
	 * 新增黄历
	 * @param Almanac
	 */
	@Override
	public boolean addAlmanac(Almanac almanac) {
		boolean b = almanacDao.addAlmanac(almanac);
		return b;
	}
	/**
	 * 删除指定的黄历
	 * @param AlmanacId
	 */
	@Override
	public boolean delAlmanac(Integer almanacId) {
		boolean b = almanacDao.delAlmanac(almanacId);
		return b;
	}
	/**
	 * 更新黄历
	 * @param Almanac
	 */
	@Override
	public boolean updateAlmanac(Almanac almanac) {
		boolean b = almanacDao.updateAlmanac(almanac);
		return b;
	}
	/**
	 * 装载指定的黄历
	 * @param merAlmanac
	 */
	@Override
	public Almanac loadAlmanac(Integer almanacId) {
		Almanac almanac = almanacDao.loadAlmanac(almanacId);
		return almanac;
	}
	
	/**
	 * 浏览黄历
	 * @param merAlmanac
	 */
	@Override
	public List<Almanac> browseAlmanac(String orderName, String orderWay) {
		List<Almanac> l = almanacDao.browseAlmanac(orderName, orderWay);
		return l;
	}
	/**
	 * 分页浏览黄历
	 * @param merAlmanac
	 */
	@Override
	public List<Almanac> browsePagingAlmanac( int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<Almanac> l = almanacDao.browsePagingAlmanac(pageNum-1, pageSize, orderName, orderWay);
		return l;
	}
	/**
	 * 根据时间查询黄历
	 * @param merAlmanac
	 */
	@Override
	public Almanac loadAlmanacByDate(int y, int m, int d) {
		if(y==0){
		y = Calendar.getInstance().get(Calendar.YEAR);
		m = Calendar.getInstance().get(Calendar.MONTH)+1;
		d = Calendar.getInstance().get(Calendar.DATE);
		}
		Almanac a = almanacDao.loadAlmanacByDate(y, m, d);
		return a;
	}

}
