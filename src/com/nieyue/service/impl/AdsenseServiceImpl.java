package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.Adsense;
import com.nieyue.dao.AdsenseDao;
import com.nieyue.service.AdsenseService;

/**
 *  广告位业务实现类
 * @author Administrator
 *
 */
@Service
public class AdsenseServiceImpl implements AdsenseService {
	@Resource
	AdsenseDao adsenseDao;
	/**
	 * 增加广告位
	 */
	@Override
	public boolean addAdsense(Adsense adsense) {
		boolean b = adsenseDao.addAdsense(adsense);
		return b;
	}
	
	/**
	 * 更改广告位
	 */
	@Override
	public boolean updateAdsense(Adsense adsense) {
		boolean b = adsenseDao.updateAdsense(adsense);
		return b;
	}
	/**
	 * 查询广告位
	 */
	@Override
	public List<Adsense> browseAdsense() {
	List<Adsense> l = adsenseDao.browseAdsense();
		return l;
	}
	/**
	 * 删除广告位
	 */
	@Override
	public boolean delAdsense(Integer adsenseId) {
		boolean b = adsenseDao.delAdsense(adsenseId);
		return b;
	}
	/**
	 * 加载广告位
	 */
	@Override
	public Adsense loadAdsense(Integer adsenseId) {
		Adsense a = adsenseDao.loadAdsense(adsenseId);
		return a;
	}
	/**
	 *  根据类型浏览注册账户
	 */
	@Override
	public List<Adsense> browseAdsenseByType(Integer type) {
		List<Adsense> l = adsenseDao.browseAdsenseByType(type);
		return l;
	}
	
}
