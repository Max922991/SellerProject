package com.example.sellerproject.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellerDTO {

    String name;
    String email;
    String phoneNumber;
}
