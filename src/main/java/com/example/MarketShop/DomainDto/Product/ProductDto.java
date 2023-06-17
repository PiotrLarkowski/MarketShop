package com.example.MarketShop.DomainDto.Product;

import lombok.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class ProductDto {
    @NotNull
    private String productName;
    @NotNull
    private double productPrice;
}
