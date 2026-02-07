package com.springboot.springbootstudy.service;

import com.springboot.springbootstudy.data.dto.ProductDto;
import com.springboot.springbootstudy.data.dto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);
    ProductResponseDto changeProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
