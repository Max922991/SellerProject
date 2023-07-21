package com.example.sellerproject.controllers;

import com.example.sellerproject.dto.ProductDTO;
import com.example.sellerproject.dto.ResponseDTO;
import com.example.sellerproject.models.Product;
import com.example.sellerproject.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create/{id}")
    public ResponseDTO createProduct(@PathVariable(value = "id", required = true) Long sellerId,
                                     @RequestBody Product product) {
        return productService.createProduct(sellerId, product);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts(
            @RequestParam(value = "pageNo", required = false, defaultValue = "") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        return productService.getProductsUsePagination(pageNo, pageSize);
    }


}
