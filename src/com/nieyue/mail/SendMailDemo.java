package com.nieyue.mail;

public class SendMailDemo {
	
	public static void sendMail(String emailSearch ,int emailCode){
		
		// 设置邮件服务器信息
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.mxhichina.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		
		// 邮箱用户名
		mailInfo.setUserName("benzhenchayuan@yayao8.com");
		// 邮箱密码
		mailInfo.setPassword("yayao123+++");
		// 发件人邮箱
		mailInfo.setFromAddress("benzhenchayuan@yayao8.com");
		// 收件人邮箱
		mailInfo.setToAddress(emailSearch);
		//mailInfo.setToAddress("278076304@qq.com");
		// 邮件标题
		mailInfo.setSubject("雅耀广告系统");
		// 邮件内容
		StringBuffer buffer = new StringBuffer();
		buffer.append("<strong style='font-size:38px;'>雅耀广告系统</strong><br/><hr/>");
		buffer.append("请在提交请求后的10分钟内，通过下面的验证码激活并确认您的账号:<br/>");
		//buffer.append("<a href='http://localhost:8080/YaYaoXiangXiu/retrieveAccountBack.html'>http://localhost:8080/YaYaoXiangXiu/retrieveAccountBack.html</a><br/>");
		buffer.append("验证码：<span style='font-weight:bold;color:blue;'>"+emailCode+"</span>");
		buffer.append("（该验证码在10分钟有效，10分钟后需要重新获取验证邮件）<br/>如果该验证码无法验证，请重新获取。<br/>如果这不是您的邮件，请忽略此邮件。<br/>这是雅耀广告系统系统邮件，请勿回复。");
		mailInfo.setContent(buffer.toString());
		//SimpleMailSender sml=new SimpleMailSender();
		// sml.sendTextMail(mailInfo);
		SimpleMailSender.sendHtmlMail(mailInfo);
	}
	public static boolean sendSelfMail(MailSenderInfo mailInfo){
		boolean s = SimpleMailSender.sendHtmlMail(mailInfo);
		return s;
	}
	public static void sendSafeMail(  final String es , final int ec ) throws InterruptedException{
		Thread ss=new Thread(new Runnable() {
			public void run() {
				sendMail(es,ec);
			}
		});
		ss.start();
		//ss.join();//优点安全，缺点阻塞
	}
	
	public static void main(String[] args) throws InterruptedException {
		//sendMail("278076304@qq.com",(int) (Math.random()*9000+1000));
		//System.out.println("发送成功");
		// 设置邮件服务器信息
				MailSenderInfo mailInfo = new MailSenderInfo();
				mailInfo.setMailServerHost("smtp.mxhichina.com");
				mailInfo.setMailServerPort("25");
				mailInfo.setValidate(true);
				
				// 邮箱用户名
				mailInfo.setUserName("benzhenchayuan@yayao8.com");
				// 邮箱密码
				mailInfo.setPassword("yayao123+++");
				// 发件人邮箱
				mailInfo.setFromAddress("benzhenchayuan@yayao8.com");
				// 收件人邮箱
				mailInfo.setToAddress("278076304@qq.com");
				// 邮件标题
				mailInfo.setSubject("日本裸祭节，近万名男女庙内不穿衣服抢夺神木！");
				// 邮件内容
				StringBuffer buffer = new StringBuffer();
				buffer.append("<strong style='font-size:38px;'>日本裸祭节，近万名男女庙内不穿衣服抢夺神木！</strong><br/><hr/>");
				buffer.append("<a href='http://man.fuwu88.cn/man/news_details?type=%E5%A5%87%E9%97%BB&news_id=9331#'><img src='http://man.fuwu88.cn/uploaderPath/ueditor/image/20170207/1486431046149068348.jpg'/></a><br/>");
				mailInfo.setContent(buffer.toString());
		       sendSelfMail(mailInfo);
	}
	
} 