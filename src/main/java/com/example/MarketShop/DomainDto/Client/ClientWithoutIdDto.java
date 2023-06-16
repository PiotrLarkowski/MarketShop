package com.example.MarketShop.DomainDto.Client;

import com.example.MarketShop.Domain.Basket;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class ClientWithoutIdDto {
    private String clientFirstName;
    private String clientLastName;
    private String clientPhoneNumber;
    private String clientEMailAddress;
    private Basket clientBasket;
}
