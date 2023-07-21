package com.example.sellerproject.services;

import com.example.sellerproject.dto.ResponseDTO;
import com.example.sellerproject.dto.SellerDTO;
import com.example.sellerproject.event.SellerEventPublisher;
import com.example.sellerproject.exception.ResourceNotFoundException;
import com.example.sellerproject.mappers.SellerMappers;
import com.example.sellerproject.models.Seller;
import com.example.sellerproject.repository.SellerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellerService {
    private final SellerRepo sellerRepo;
    private final SellerMappers sellerMappers;
    private final SellerEventPublisher eventPublisher;

    @Transactional
    @Caching(cacheable = {
            @Cacheable(value = "SellerService::getSellerById", key = "#id"),
            @Cacheable(value = "SellerService::getSellerByEmail", key = "#email")
    })
    public ResponseDTO createSeller(Seller seller) {
        sellerRepo.save(seller);
        eventPublisher.publishSellerRegistration(seller);
        return ResponseDTO.builder()
                .answer("You add new seller: " + seller.getSeller_name())
                .build();
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "SellerService::getSellerById", key = "#id")
    public SellerDTO getSellerById(Long id) {
        Seller seller = sellerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller with id " + id + " not found"));
        return sellerMappers.toSellerDTO(seller);
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "SellerService::getSellerByEmail", key = "#email")
    public SellerDTO getSellerByEmail(String email) {
        Seller byEmail = sellerRepo.findByEmail(email);
        return sellerMappers.toSellerDTO(byEmail);
    }

    @Transactional
    @Caching(put = {
            @CachePut(value = "SellerService::getSellerById", key = "#seller.id"),
            @CachePut(value = "SellerService::getSellerByEmail", key = "#seller.email")
    })
    public SellerDTO updateSeller(Seller seller) {
        return sellerMappers.toSellerDTO(sellerRepo.save(seller));
    }

    @Transactional
    @CacheEvict(value = "SellerService::getSellerById", key = "#id")
    public ResponseDTO deleteSeller(Long id) {
         sellerRepo.deleteById(id);
         return ResponseDTO.builder()
                 .answer("The Seller was delete!!!")
                 .build();
    }


}
