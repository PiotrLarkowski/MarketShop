package com.example.MarketShop.Domain;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Table(name = "USERS")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String clientFirstName;
    private String clientLastName;
    private String clientPhoneNumber;
    private String clientEMailAddress;
    @OneToMany(mappedBy = "productForeignKeyId")
    private List<Product> clientProductList=new ArrayList<>();

    public void addProductToBasket(Product product){
        clientProductList.add(product);
    }

    public void removeProductFromBasket(Product product){
        clientProductList.remove(product);
    }
}
