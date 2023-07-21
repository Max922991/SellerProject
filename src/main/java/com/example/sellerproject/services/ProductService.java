package com.example.sellerproject.services;

import com.example.sellerproject.dto.ProductDTO;
import com.example.sellerproject.dto.ResponseDTO;
import com.example.sellerproject.exception.ProductNotValidException;
import com.example.sellerproject.exception.ResourceNotFoundException;
import com.example.sellerproject.mappers.ProductMapper;
import com.example.sellerproject.models.Product;
import com.example.sellerproject.models.Seller;
import com.example.sellerproject.repository.ProductRepo;
import com.example.sellerproject.repository.SellerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final SellerRepo sellerRepo;
    private final ProductMapper productMapper;


    public ResponseDTO createProduct(Long sellerId, Product product) {
        Seller seller = sellerRepo.findById(sellerId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not found"));
        if (product.getTitle() == null || product.getDescription() == null) {
            throw new ProductNotValidException("Title or description is not valid");
        }
        List<Product> products = seller.getProducts();
        products.add(product);
        seller.setProducts(products);
        sellerRepo.save(seller);
        return ResponseDTO.builder()
                .answer("You add product: " + product.getTitle())
                .build();
    }
    public ProductDTO getProductById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product with id " + id + " not found"));
        return productMapper.toProductDTO(product);
    }

    public List<ProductDTO> getProductsUsePagination(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<Product> products = productRepo.findAll(pageRequest);
        List<Product> listOfProducts = products.getContent();
        return productMapper.toProductDTOList(listOfProducts);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findProductsBySellerId(Long id) {
        List<Product> productsBySellerId = productRepo.findProductsBySellerId(id);
        return productMapper.toProductDTOList(productsBySellerId);
    }





}
