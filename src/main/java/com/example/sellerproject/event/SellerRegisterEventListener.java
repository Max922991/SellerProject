package com.example.sellerproject.event;

import com.example.sellerproject.mail.MailSenderService;
import com.example.sellerproject.models.Seller;
import com.example.sellerproject.services.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SellerRegisterEventListener {
    private final MailSenderService mailSender;

    @EventListener(SellerService.class)
    public void handleSellerRegisteredEvent(SellerRegisterEvent event) {
        Seller seller = event.getSeller();
        String email = seller.getEmail();
        mailSender.sendEmail(email);
    }
}
