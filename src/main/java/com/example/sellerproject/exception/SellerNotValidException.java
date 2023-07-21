package com.example.sellerproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SellerNotValidException extends RuntimeException {

    public SellerNotValidException(String message) {
        super(message);
    }
}
