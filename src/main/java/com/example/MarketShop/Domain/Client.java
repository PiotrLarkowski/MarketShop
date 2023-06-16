package com.example.MarketShop.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String clientFirstName;
    private String clientLastName;
    private String clientPhoneNumber;
    private String clientEMailAddress;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "productId", cascade = CascadeType.ALL)
    private List<Product> clientProductList;

    public void addProductToBasket(Product product){
        clientProductList.add(product);
    }

    public void removeProductFromBasket(Product product){
        clientProductList.remove(product);
    }
}
