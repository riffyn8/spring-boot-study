package com.springboot.springbootstudy.service.impl;

import com.springboot.springbootstudy.data.dao.ProductDAO;
import com.springboot.springbootstudy.data.dto.ProductDto;
import com.springboot.springbootstudy.data.dto.ProductResponseDto;
import com.springboot.springbootstudy.data.entity.Product;
import com.springboot.springbootstudy.data.repository.ProductRepository;
import com.springboot.springbootstudy.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/*
DB와 밀접한 관련이 있는 데이터 액세스 레이어까지는 앤티티객체
클라이언트와 가까워지는 다른 레이어는 DTO를 사용
*/
@Service
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        LOGGER.info("[getProduct] input number : {}", number);
        Product product = productRepository.findById(number).get();

        LOGGER.info("[getProduct] product number: {}, name: {}", product.getNumber(), product.getName());

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
        // DTO객체를 다룰 때 롬복의 @Builder 사용
        // 필요한 필드만 선택해서 Entity 객체를 생성하기 좋음
        // 또한 필드의 순서가 달라도 문제가 없음
        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .build();

        Product savedProduct = productRepository.save(product);
        LOGGER.info("[saveProduct] savedProduct: {}", savedProduct);

        // @Builder로 변경
        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .number(savedProduct.getNumber())
                .name(savedProduct.getName())
                .price(savedProduct.getPrice())
                .stock(savedProduct.getStock())
                .build();

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product product = productRepository.findById(number).get();
        product.setName(name);
        Product changedProduct = productRepository.save(product);
        /*
        Builder는 새로운 객체를 처음 만들어서 생성할 때 사용하는 것이 좋음.
        위와 같이 기존 객체의 값만 바꿀 땐 Setter를 사용하거나, 별도의 메서드를 사용

        + 생성자는 팩토리 메서드 내부에서 객체를 실제 생성할 때 사용하는 것이 좋음
        팩토리 메서드는 외부에서 객체 생성의 복잡한 로직을 알 필요 없게 캡슐화하는 역할을 함.
        또한, 생성자는 클래스 이름과 같아야 하지만 팩토리 메서드는 목적에 맞는 이름을 붙일 수 있음
        DTO 구조가 바뀌면 팩토리 메서드만 고치면 됨
        호출 하는 쪽에서는 객체가 어떻게 만들어지는지 몰라도 됨.

        // DTO 클래스 내부
        public static ProductResponseDto from(Product product) {
        return ProductResponseDto.builder()
            .number(product.getNumber())
            .name(product.getName())
            .price(product.getPrice())
            .stock(product.getStock())
            .build();
}

        // Service 계층 (호출하는 쪽)
        ProductResponseDto dto = ProductResponseDto.from(product);
        */

        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .number(changedProduct.getNumber())
                .name(changedProduct.getName())
                .price(changedProduct.getPrice())
                .stock(changedProduct.getStock())
                .build();

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productRepository.deleteById(number);
    }
}
