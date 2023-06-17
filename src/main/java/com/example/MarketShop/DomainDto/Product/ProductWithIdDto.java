package com.example.MarketShop.DomainDto.Product;

import lombok.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class ProductWithIdDto {
    @NotNull
    private Long productId;
    @NotNull
    private String productName;
    @NotNull
    private double productPrice;
}
