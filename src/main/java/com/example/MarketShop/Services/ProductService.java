package com.example.MarketShop.Services;

import com.example.MarketShop.Domain.Product;
import com.example.MarketShop.DomainDto.Product.ProductDto;
import com.example.MarketShop.DomainDto.Product.ProductWithoutIdDto;
import com.example.MarketShop.Exceptions.Product.ProductNotFoundException;
import com.example.MarketShop.Repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public List<Product> getAllProducts(){
        ArrayList<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(product -> productList.add(product));
        log.info("Returning all products");
        return productList;
    }
    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
    public Product upadteProduct(ProductWithoutIdDto productWithIdDto){
        Product product = productRepository.findById(productWithIdDto.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(productWithIdDto.getProductId()));
        product.setProductName(productWithIdDto.getProductName());
        product.setProductPrice(productWithIdDto.getProductPrice());
        log.info("Successful updated product: "+productWithIdDto.getProductName());
        return product;
    }
    public void deleteProduct(ProductWithoutIdDto productWithIdDto){
        productRepository.delete(productRepository.findById(productWithIdDto.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(productWithIdDto.getProductId())));
    }
}
