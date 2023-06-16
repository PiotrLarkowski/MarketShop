package com.example.MarketShop.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Basket {
    private Long basketId;
    private List<Product> selectedProducts;

    public void addProduct(Product product){
        selectedProducts.add(product);
    }
    public void removeProduct(Product product){
        selectedProducts.remove(product);
    }
}
