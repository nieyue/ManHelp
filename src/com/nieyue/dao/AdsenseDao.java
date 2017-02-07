package com.nieyue.dao;

import java.util.List;

import com.nieyue.bean.Adsense;
/**
 * 广告位接口
 * @author yy
 *
 */
public interface AdsenseDao {
	
	/** 新增注册账户 */	
	public boolean addAdsense( Adsense  adsense) ;
	/** 修改注册账户信息 */	
	public boolean updateAdsense( Adsense adsense) ;
	/** 浏览注册账户*/
	public List< Adsense> browseAdsense() ;
	/** 根据类型浏览注册账户*/
	public List< Adsense> browseAdsenseByType(Integer type) ;
	/** 删除注册账户 */	
	public boolean delAdsense(Integer adsenseId) ;
	/**装载注册账户 */	
	public  Adsense loadAdsense(Integer adsenseId);	
}
