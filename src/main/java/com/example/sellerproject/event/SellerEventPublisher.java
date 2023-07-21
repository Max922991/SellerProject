package com.example.sellerproject.event;

import com.example.sellerproject.models.Seller;

public interface SellerEventPublisher {
    void publishSellerRegistration(Seller registerSeller);
}
