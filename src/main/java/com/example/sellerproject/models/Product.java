package com.example.sellerproject.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "title")
    @NotNull(message = "title must be not null")
    String title;
    @Column(name = "description")
    @NotNull(message = "description must be not null")
    String description;
    @Column(name = "price")
    @NotNull
    int price;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    Seller seller;

}
