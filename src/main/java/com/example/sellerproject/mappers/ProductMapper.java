package com.example.sellerproject.mappers;

import com.example.sellerproject.dto.ProductDTO;
import com.example.sellerproject.models.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);
    Product toProductEntity(ProductDTO productDTO);
    List<ProductDTO> toProductDTOList(List<Product> products);

}
