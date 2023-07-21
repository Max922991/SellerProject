package com.example.sellerproject.event;

import com.example.sellerproject.models.Seller;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerEventPublisherImpl implements SellerEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publishSellerRegistration(Seller registerSeller) {
         eventPublisher.publishEvent(new SellerRegisterEvent(this, registerSeller));
    }
}
