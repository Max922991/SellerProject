package com.example.sellerproject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO {

    @NotNull
    String sellerName;
    @NotNull
    String email;
    @NotNull
    String phoneNumber;
}
