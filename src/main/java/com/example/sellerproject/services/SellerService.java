package com.example.sellerproject.services;

import com.example.sellerproject.dto.ResponseDTO;
import com.example.sellerproject.dto.SellerDTO;
import com.example.sellerproject.event.SellerEventPublisher;
import com.example.sellerproject.exception.ResourceNotFoundException;
import com.example.sellerproject.mappers.SellerMappers;
import com.example.sellerproject.models.Seller;
import com.example.sellerproject.repository.SellerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SellerService {
    private final RedisTemplate redisTemplate;
    private final SellerRepo sellerRepo;
    private final SellerMappers sellerMappers;
    private final SellerEventPublisher eventPublisher;
    public static final String KEY = "Seller";

    public ResponseDTO createSeller(Seller seller) {
        redisTemplate.opsForHash().put(KEY, seller.getId().toString(), seller);
        sellerRepo.save(seller);
        eventPublisher.publishSellerRegistration(seller);
        return ResponseDTO.builder()
                .answer("You add new seller: " + seller.getSellerName())
                .build();
    }

    public SellerDTO getSellerById(Long id) {
        try {
            redisTemplate.opsForHash().get(KEY, id.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return sellerMappers.toSellerDTO(sellerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not found!!!")));

    }

    public SellerDTO getSellerByEmail(String email) {
        Seller byEmail = sellerRepo.findByEmail(email);
        return sellerMappers.toSellerDTO(byEmail);
    }

    public SellerDTO updateSeller(Seller seller) {
        return sellerMappers.toSellerDTO(sellerRepo.save(seller));
    }

    public ResponseDTO deleteSeller(Long id) {
        sellerRepo.deleteById(id);
        return ResponseDTO.builder()
                .answer("The Seller was delete!!!")
                .build();
    }
}
