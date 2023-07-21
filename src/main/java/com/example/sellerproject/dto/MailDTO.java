package com.example.sellerproject.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class MailDTO {

    String from;
    String to;
    String subject;
    String message;
}
