package com.example.sellerproject.mail;

import com.example.sellerproject.dto.MailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderServiceImpl implements MailSenderService {
    private final JavaMailSender mailSender;

    //  @Value("${spring.mail.username}")
    //   private String EMAIL = "max43223@gmail.com";

    @Override
    public void sendEmail(String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        MailDTO mailDTO = MailDTO.builder()
                .to(email)
                .subject("Register new Seller")
                .message("Welcome to our app!!!")
                .build();
        mailMessage.setTo(mailDTO.getTo());
        mailMessage.setSubject(mailDTO.getSubject());
        mailMessage.setText(mailDTO.getMessage());
        mailSender.send(mailMessage);
    }
}
