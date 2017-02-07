package com.nieyue.test;

import java.util.Date;
import java.util.UUID;

import com.baidu.ueditor.PathFormat;

public class Test1 {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(UUID.randomUUID().toString().replace("-", ""));
				System.out.println(new Date());
			}
		};
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		String url="D:/nieyue/tomcat/apache-tomcat-7.0.57-windows-x64/apache-tomcat-7.0.57/webapps/YaYaoMall/resources/ariticle/image/20160809/1470726115383063406.png";
		String path = PathFormat.format(url);
		String getpath= path.replace( "D:/nieyue/tomcat/apache-tomcat-7.0.57-windows-x64/apache-tomcat-7.0.57/webapps/YaYaoMall/", "/" );
		System.out.println(PathFormat.format( getpath ));
		
		System.out.println("D:\\nieyue\\tomcat\\".replace( "\\", "/" ));
	}
	
	
}

