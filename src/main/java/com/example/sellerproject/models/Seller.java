package com.example.sellerproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "sellers")
public class Seller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "seller_name")
    @NotNull(message = "Name must be not null")
    String seller_name;
    @Column(name = "email")
    @NotNull(message = "Email must be not null")
    String email;
    @Column(name = "phone_number")
    String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    List<Product> products = new ArrayList<>();
}
