package com.example.MarketShop.Services;

import com.example.MarketShop.Domain.Product;
import com.example.MarketShop.DomainDto.ProductDto;
import com.example.MarketShop.Repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createNewProduct(ProductDto productDto){
        Product product = Product.builder()
                .productName(productDto.getProductName())
                .productPrice(productDto.getProductPrice())
                .build();
        productRepository.save(product);
        log.info("Product " + productDto.getProductName() + " has been made");
        return product;
    }
}
