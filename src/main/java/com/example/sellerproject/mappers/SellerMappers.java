package com.example.sellerproject.mappers;

import com.example.sellerproject.dto.SellerDTO;
import com.example.sellerproject.models.Seller;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellerMappers {

    SellerDTO toSellerDTO(Seller seller);
    Seller toSellerEntity(SellerDTO sellerDTO);

}
