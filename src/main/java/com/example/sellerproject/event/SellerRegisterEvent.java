package com.example.sellerproject.event;

import com.example.sellerproject.models.Seller;
import org.springframework.context.ApplicationEvent;

public class SellerRegisterEvent extends ApplicationEvent {

    private final Seller seller;

    public SellerRegisterEvent(Object source, Seller seller) {
        super(source);
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }
}
