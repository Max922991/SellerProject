package com.example.sellerproject.validation;

import com.example.sellerproject.exception.SellerNotValidException;
import com.example.sellerproject.models.Seller;
import com.example.sellerproject.repository.SellerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SellerIsValid {

    private final SellerRepo sellerRepo;

    public void isValid(Seller seller) {
        Optional<Seller> sellerOptional = sellerRepo.findById(seller.getId());
        if (!sellerOptional.isEmpty()) {
            throw new SellerNotValidException("There is already such a seller");
        }
        if (seller.getSeller_name() == null || seller.getSeller_name().isEmpty()) {
          throw new SellerNotValidException("Name must be not empty");
        }
        if (seller.getEmail() == null || seller.getEmail().isEmpty()) {
            throw new SellerNotValidException("Email must be not empty");
        }
        if (!seller.getEmail().matches("[A-Za-z0-9\\s-]+")){        //todo заменить regex на Email
            throw new SellerNotValidException("Email is not valid");
        }
    }
}
