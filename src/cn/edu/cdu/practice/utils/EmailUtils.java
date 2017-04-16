package cn.edu.cdu.practice.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cn.edu.cdu.practice.model.MailboxVerification;

/**
 * @Copyright (C), 2017, 成都大学信息科学与工程学院JavaWeb教材编写组.
 * @FileName TestDb.java
 * @version 1.0
 * @Description: 发送邮件工具类
 * @Author 陈天雄
 * @Date： 2017-4-16:下午3:37:43
 * Modification User： 程序修改时由修改人员编写
 * Modification Date： 程序修改时间
 */
public class EmailUtils {
	public static boolean sendMail(String email,int type) {
		 Properties p = new Properties();  
		 //smtp服务器信息
	     p.put("mail.smtp.host", "smtp.qq.com");  
	     p.put("mail.smtp.port", "25");
	     p.put("mail.smtp.auth", "true");  
	     
	     //设置发送邮件的账号和密码
	     Session session = Session.getInstance(p, new Authenticator() {
	         @Override
	         protected PasswordAuthentication getPasswordAuthentication() {
	         //两个参数分别是发送邮件的账户和密码
	         return new PasswordAuthentication("","");
	                 }
	      });  
	     //生成验证码
	     String identifyCode = IdentifyCodeUtils.getCode();
	     MailboxVerification mailboxVerification = new MailboxVerification(email, type, identifyCode);
	     //创建邮件对象
	     Message mailMessage = new MimeMessage(session);  
	     try {  
	         System.out.println("I'm sending...");  
	         Address from = new InternetAddress("");  
	         //设置发出方  
	         mailMessage.setFrom(from);  
	         Address to = new InternetAddress(email);
	         //设置接收人员  
	         mailMessage.setRecipient(Message.RecipientType.TO, to);  
	         mailMessage.setSubject("成都大学信工学院企业注册验证");//设置邮件标题  
	         mailMessage.setText("您的验证码是"+identifyCode+"，请确认是本人操作"); //设置邮件内容  
	         // 发送邮件  
	         Transport.send(mailMessage);  
	         return true;  
	     } catch (Exception e) {  
	         e.printStackTrace();  
	     }  
	     	return false;  
	 }  
}
