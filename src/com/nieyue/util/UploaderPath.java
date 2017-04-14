package com.nieyue.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 文件上传路径
 * @author yy
 *
 */
public class UploaderPath {
	
	/**
	 * 读取 properties
	 * @param key
	 * @return
	 */
	public static String GetValueByKey(String key){
         Properties prop = new Properties();  
  		String path = UploaderPath.class.getClassLoader().getResource("config/uploaderPath.properties").getPath();  
  		InputStream is;
  		try {
  			is = new FileInputStream(path);
  				prop.load(is);
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			return null;
  		}  
  		String value = (String) prop.get(key);
  		return value;
	}
	public static void main(String[] args) {
		System.out.println(UploaderPath.GetValueByKey("SUCCESS"));
		//System.out.println(SUCCESS);
	}
	/**
	 * 根目录
	 */
	public static String ROOTPATH="ROOTPATH";
	/**
	 * 文件
	 */
	public static String FILE="FILE";
	/**
	 * 图片
	 */
	public static String IMG="IMG";
	/**
	 * 音频
	 */
	public static String AUDIO="AUDIO";
	/**
	 * 视频
	 */
	public static String VIDEO="VIDEO";
	
}
