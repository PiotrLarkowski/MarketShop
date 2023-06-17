package com.example.MarketShop.DomainDto.Client;

import lombok.*;
import javax.validation.constraints.NotNull;

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
