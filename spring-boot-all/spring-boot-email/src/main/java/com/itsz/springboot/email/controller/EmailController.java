package com.itsz.springboot.email.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/send")
    public void sendEmail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("jeremygilbert@126.com");
        mailMessage.setSubject("Tester Subject");
        mailMessage.setTo("hb.zhou@itsz.cn");
        mailMessage.setCc("645123820@qq.com");
        mailMessage.setText("This is email Test");
        javaMailSender.send(mailMessage);
    }

    @GetMapping("/sendHtmlEmail")
    public void sendHtmlEmail() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = getMimeMessageHelper(message, "Testing Html email");
        javaMailSender.send(message);
    }


    @GetMapping("/sendAttachEmail")
    public void sendAttachEmail() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = getMimeMessageHelper(message, "Testing Attach email");
        FileSystemResource resource = new FileSystemResource(new File("D:\\Jeremy\\spring\\hello-world\\spring-boot-all\\spring-boot-email\\src\\main\\resources\\application.yml"));
        helper.addAttachment("application.yml", resource);
        javaMailSender.send(message);
    }

    private MimeMessageHelper getMimeMessageHelper(MimeMessage message, String s) throws MessagingException {
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("jeremygilbert@126.com");
        helper.setSubject(s);
        helper.setTo("hb.zhou@itsz.cn");
        helper.setCc("645123820@qq.com");
        helper.setText("<p style='color:#42b983'>使用Spring Boot发送HTML格式邮件。</p>", true);
        return helper;
    }

    @GetMapping("/sendTemplateEmail")
    public void sendTemplateEmail(String code) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("jeremygilbert@126.com");
        helper.setSubject("Testing Html email");
        helper.setTo("hb.zhou@itsz.cn");
        helper.setCc("645123820@qq.com");

        Context context = new Context();
        context.setVariable("code", code);
        String template = templateEngine.process("emailTemplate", context);
        helper.setText(template, true);
        javaMailSender.send(message);
    }
}
