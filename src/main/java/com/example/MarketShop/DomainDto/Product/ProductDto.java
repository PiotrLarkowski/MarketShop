package com.example.MarketShop.DomainDto.Product;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

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
