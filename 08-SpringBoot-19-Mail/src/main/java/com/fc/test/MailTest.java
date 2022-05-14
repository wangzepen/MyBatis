package com.fc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class MailTest {
    // java的邮件发送器
    @Autowired
    private JavaMailSender sender;

    @Test
    void testSimpleMail() {
        // 创建一个简单邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件的发送人
        message.setFrom("412790423@qq.com");
        // 设置邮件的接收人
        message.setTo("3335939034@qq.com",
                "1261964617@qq.com",
                "2809697225@qq.com",
                "2998701715@qq.com"
                );

        // 设置邮件的主题
        message.setSubject("永久冻结通知");

        // 设置邮件的内容
        message.setText("你好，您的QQ号有违规操作，将在24小时内被永久冻结，请将账户相关资金尽快转移，避免给你造成困扰！有疑问请联系负责人QQ：412790423");
//        // 设置抄送人
//        message.setCc("635702657@qq.com");
//        // 秘密抄送
//        message.setBcc("1977331678@qq.com");

        sender.send(message);
    }
}
