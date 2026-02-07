package com.springboot.springbootstudy.data.dao.impl;

import com.springboot.springbootstudy.data.dao.ProductDAO;
import com.springboot.springbootstudy.data.entity.Product;
import com.springboot.springbootstudy.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        /*
        findById(): 메서드를 호출하는 즉시 SELECT 쿼리 실행. Optional<T>로 반환
        getReferenceById() (구 getById()): 객체의 내부 데이터가 필요해질 때 쿼리 실행
        */

        Product selectedProduct = productRepository.findById(number).orElse(null);

        return selectedProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            
            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());
            
            updatedProduct = productRepository.save(product);
        } else 
            throw  new Exception("update 중 에러 발생");

        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            productRepository.delete(product);
        } else
            throw new Exception("delete 중 에러 발생");
    }
}
