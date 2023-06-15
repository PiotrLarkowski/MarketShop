package com.example.MarketShop.Controllers;

import com.example.MarketShop.Domain.Product;
import com.example.MarketShop.DomainDto.ProductDto;
import com.example.MarketShop.Services.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public Product createProduct(@RequestBody @Validated ProductDto productDto){
        return productService.createNewProduct(productDto);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping(path = "/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
}
