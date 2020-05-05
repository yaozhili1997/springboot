package com.yzl.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBoot12MailApplicationTests {
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Test
    void testSimpleMail() {
        //封装简单的邮件内容
        SimpleMailMessage message = new SimpleMailMessage();
        //标题
        message.setSubject("放假通知");
        //正文
        message.setText("今年因为瘟疫原因不会开学了");
        //发件人
        message.setFrom("1144946637@qq.com");
        //收件人
        message.setTo("1393503694@qq.com");
        javaMailSender.send(message);
    }
    @Test
    void testDifficultMail() throws MessagingException {
        //封装复杂的邮件内容
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //通过消息帮助对象来设置发送内容，第二个参数为true标识可以发送附件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //标题
        helper.setSubject("放假通知");
        //正文,第二个参数为true还可以发送html代码
        helper.setText("<h2 style='color:red'>今年因为瘟疫原因不会开学了</h2>",true);
        //发送附件
        helper.addAttachment("new.jpg", new File("C:\\Users\\yaozhili\\Pictures\\new.jpg"));
        //发件人
        helper.setFrom("1144946637@qq.com");
        //收件人
        helper.setTo("1393503694@qq.com");
        javaMailSender.send(mimeMessage);
    }
}
