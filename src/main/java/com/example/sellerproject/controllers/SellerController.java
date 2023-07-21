package com.example.sellerproject.controllers;

import com.example.sellerproject.dto.ResponseDTO;
import com.example.sellerproject.dto.SellerDTO;
import com.example.sellerproject.models.Seller;
import com.example.sellerproject.services.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @PostMapping("/register")
    public ResponseDTO registerSeller(@RequestBody Seller seller) {
       return sellerService.createSeller(seller);
    }

    @GetMapping("/{id}")
    public SellerDTO getSellerById(@PathVariable Long id) {
       return sellerService.getSellerById(id);
    }

}
