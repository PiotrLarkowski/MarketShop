package com.example.MarketShop.DomainDto.Client;

import com.example.MarketShop.Domain.Product;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class ClientDto {
    @NotNull
    private Long clientId;
    @NotNull
    private Long productForeignKeyId;
    @NotNull
    private String clientFirstName;
    @NotNull
    private String clientLastName;
    @NotNull
    private String clientPhoneNumber;
    @NotNull
    private String clientEMailAddress;
}
