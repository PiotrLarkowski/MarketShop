package com.example.MarketShop.DomainDto.Client;

import com.example.MarketShop.Domain.Basket;
import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class ClientDto {
    private Long clientId;
    private String clientFirstName;
    private String clientLastName;
    private String clientPhoneNumber;
    private String clientEMailAddress;
    private Basket clientBasket;
}
