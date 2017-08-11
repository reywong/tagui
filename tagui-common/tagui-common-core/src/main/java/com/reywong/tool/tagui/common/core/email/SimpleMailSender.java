/**
 *
 * File Desc:    
 *
 * Product AB:   热风投资有限公司
 *
 * Module Name:  
 *
 * Author:       wangrui
 *
 * Create:       13-6-18-下午5:56
 *
 * History:      13-6-18-下午5:56 modify  by  wangrui
 */
package com.reywong.tool.tagui.common.core.email;


import com.yxtc.framework.platform.util.StringUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class SimpleMailSender {

    /**
     * 以文本格式发送邮件
     *
     * @param mailInfo 待发送的邮件的信息
     */
    public boolean sendTextMail(MailSenderInfo mailInfo) {
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());

        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session

        Session sendMailSession = Session.getInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
//            Address to = new InternetAddress(mailInfo.getToAddress());
//            mailMessage.setRecipient(Message.RecipientType.TO, to);
            if (StringUtils.isNotBlank(mailInfo.getToAddress())) {
                mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailInfo.getToAddress()));
            }
            if (StringUtils.isNotBlank(mailInfo.getCcAddress())) {
                mailMessage.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mailInfo.getCcAddress()));

            }
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容
//            String mailContent = mailInfo.getContent();
//            mailMessage.setText(mailContent);
            // 发送邮件
            Multipart multipart = new MimeMultipart();
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(mailInfo.getContent());
            multipart.addBodyPart(contentPart);

            //发送附件
            String[] attachFileNames = mailInfo.getAttachFileNames();
            if (attachFileNames != null && attachFileNames.length > 0) {
                //设置邮件的文本内容
                for (int i = 0; i < attachFileNames.length; i++) {
                    contentPart = new MimeBodyPart();
                    String filename = attachFileNames[i]; // 选择出每一个附件名
                    FileDataSource fds = new FileDataSource(filename); // 得到数据源
                    contentPart.setDataHandler(new DataHandler(fds)); // 得到附件本身并至入BodyPart
                    contentPart.setFileName(MimeUtility.encodeText(fds.getName()));
                    multipart.addBodyPart(contentPart);
                }
            }
            // 将multipart对象放到message中
            mailMessage.setContent(multipart); // Multipart加入到信件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return false;
    }

    /**
     * 以HTML格式发送邮件
     *
     * @param mailInfo 待发送的邮件信息
     */
    public static boolean sendHtmlMail(MailSenderInfo mailInfo) {
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        //如果需要身份认证，则创建一个密码验证器
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress(), mailInfo.getFromName());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            String[] toAddress = null;
            InternetAddress[] sendTo = null;
            String toEmail = mailInfo.getToAddress();
            if (StringUtils.isNotBlank(toEmail)) {
                toAddress = toEmail.split(";");
                sendTo = new InternetAddress[toAddress.length];
                for (int i = 0; i < toAddress.length; i++) {
                    sendTo[i] = new InternetAddress(toAddress[i]);
                }
            }

            // Message.RecipientType.TO属性表示接收者的类型为TO
            if (StringUtils.isNotBlank(mailInfo.getToAddress())) {
                mailMessage.setRecipients(Message.RecipientType.TO, sendTo);
            }

            // 抄送地址
            String[] ccAddress = null;
            InternetAddress[] ccTo = null;
            String ccEmail = mailInfo.getCcAddress();
            if (StringUtils.isNotBlank(ccEmail)) {
                ccAddress = ccEmail.split(";");
                ccTo = new InternetAddress[ccAddress.length];
                for (int i = 0; i < ccAddress.length; i++) {
                    ccTo[i] = new InternetAddress(ccAddress[i]);
                }
            }


            if (StringUtils.isNotBlank(mailInfo.getCcAddress())) {
                mailMessage.setRecipients(Message.RecipientType.CC, ccTo);

            }

            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);

            //发送附件
            String[] attachFileNames = mailInfo.getAttachFileNames();
            if (attachFileNames != null && attachFileNames.length > 0) {
                for (int i = 0; i < attachFileNames.length; i++) {
                    html = new MimeBodyPart();
                    String filename = attachFileNames[i]; // 选择出每一个附件名
                    FileDataSource fds = new FileDataSource(filename); // 得到数据源
                    html.setDataHandler(new DataHandler(fds)); // 得到附件本身并至入BodyPart
                    html.setFileName(MimeUtility.encodeText(fds.getName()));
                    mainPart.addBodyPart(html);
                }
            }

            // 将MiniMultipart对象设置为邮件内容
            mailMessage.setContent(mainPart);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return false;
    }

    /**
     * 以会议的方式发送邮件
     *
     * @param mailInfo 待发送的邮件信息
     */
    public static boolean sendMeetingMail(MailSenderInfo mailInfo) {
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        //如果需要身份认证，则创建一个密码验证器
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
//            Address to = new InternetAddress(mailInfo.getToAddress());
            // Message.RecipientType.TO属性表示接收者的类型为TO
//            mailMessage.setRecipient(Message.RecipientType.TO, to);
            if (StringUtils.isNotBlank(mailInfo.getToAddress())) {
                mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailInfo.getToAddress()));
            }
            if (StringUtils.isNotBlank(mailInfo.getCcAddress())) {
                mailMessage.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mailInfo.getCcAddress()));

            }


            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            //  mailMessage.addHeader("Mime-Version", "1.0");
            BodyPart messageBodyPart = new MimeBodyPart();
            // 测试下来如果不这么转换的话，会以纯文本的形式发送过去，
            //如果没有method=REQUEST;charset=\"UTF-8\"，outlook会议附件的形式存在，而不是直接打开就是一个会议请求
            //  messageBodyPart.setHeader("Content-Class", "urn:content-classes:calendarmessage");
            //  messageBodyPart.setHeader("Content-ID","calendar_message");
            messageBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(mailInfo.getContent(), "text/calendar;method=REQUEST;charset=UTF-8")));
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            mailMessage.setContent(multipart);
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return false;
    }


//
//    public static void main(String[] args) {
//        MailSenderInfo mailInfo = new MailSenderInfo();
//        mailInfo.setMailServerHost("smtp.163.com");
//        mailInfo.setMailServerPort("25");
//        mailInfo.setValidate(true);
//        mailInfo.setUserName("reywongcc@163.com");
//        mailInfo.setPassword("reywong123");//您的邮箱密码
//        mailInfo.setFromAddress("reywongcc@163.com");
//        mailInfo.setToAddress("wangrui@hotwind.net");
//        mailInfo.setSubject("设置邮箱标题");
//        mailInfo.setContent("设置邮箱内容");
//        //这个类主要来发送邮件
//        SimpleMailSender sms = new SimpleMailSender();
//  //      sms.sendTextMail(mailInfo);//发送文体格式
//        sms.sendHtmlMail(mailInfo);//发送html格式
//
//    }

}
