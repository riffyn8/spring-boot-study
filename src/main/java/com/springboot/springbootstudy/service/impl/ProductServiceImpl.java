package com.springboot.springbootstudy.service.impl;

import com.springboot.springbootstudy.data.dao.ProductDAO;
import com.springboot.springbootstudy.data.dto.ProductDto;
import com.springboot.springbootstudy.data.dto.ProductResponseDto;
import com.springboot.springbootstudy.data.entity.Product;
import com.springboot.springbootstudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/*
DB와 밀접한 관련이 있는 데이터 액세스 레이어까지는 앤티티객체
클라이언트와 가까워지는 다른 레이어는 DTO를 사용
*/
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductResponseDto productResponseDto = new ProductResponseDto(
                product.getNumber(),
                product.getName(),
                product.getPrice(),
                product.getStock()
        );

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto(
                savedProduct.getNumber(),
                savedProduct.getName(),
                savedProduct.getPrice(),
                savedProduct.getStock()
        );

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(number, name);

        ProductResponseDto productResponseDto = new ProductResponseDto(
                changedProduct.getNumber(),
                changedProduct.getName(),
                changedProduct.getPrice(),
                changedProduct.getStock()
        );

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}
