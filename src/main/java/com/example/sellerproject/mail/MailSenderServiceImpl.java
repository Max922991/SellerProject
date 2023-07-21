package com.example.sellerproject.mail;

import com.example.sellerproject.dto.MailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderServiceImpl implements MailSenderService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String EMAIL;

    @Override
    public String sendEmail(String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        MailDTO mailDTO = MailDTO.builder()
                .from(EMAIL)
                .to(email)
                .subject("Register new Seller")
                .message("Welcome to our app!!!")
                .build();
        mailMessage.setFrom(mailDTO.getFrom());
        mailMessage.setTo(mailDTO.getTo());
        mailMessage.setSubject(mailDTO.getSubject());
        mailMessage.setText(mailDTO.getMessage());
        return "The message is send!!!";
    }
}
