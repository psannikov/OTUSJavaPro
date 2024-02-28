package ru.otus.pro.psannikov.password.changer.services.external;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailSenderService {
    @Value("${spring.mail.template}")
    private String template;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;

    public void sendEmail(String toEmail, String subject, Context context) {
        String body = templateEngine.process(template, context);
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(toEmail);
            helper.setText(body, true);
            helper.setSubject(subject);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new IllegalArgumentException("Failed to send email", e);
        }
    }
}
