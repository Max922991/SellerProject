package com.example.sellerproject.repository;

import com.example.sellerproject.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Long> {
    Seller findByEmail(String email);
}
