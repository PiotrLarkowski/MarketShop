package com.example.MarketShop.Services;

import com.example.MarketShop.Domain.Client;
import com.example.MarketShop.Domain.Product;
import com.example.MarketShop.DomainDto.Client.ClientDto;
import com.example.MarketShop.Exceptions.Client.ClientNotFoundException;
import com.example.MarketShop.Repositories.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
@Transactional
public class ClientService {
    private final ClientRepository clientRepository;

    public Client createClient(ClientDto clientDto){
        Client client = Client.builder()
                .clientFirstName(clientDto.getClientFirstName())
                .clientLastName(clientDto.getClientLastName())
                .clientPhoneNumber(clientDto.getClientPhoneNumber())
                .clientEMailAddress(clientDto.getClientEMailAddress())
                .clientProductList(new ArrayList<>())
                .build();
        clientRepository.save(client);
        log.info("New client has been created");
        return client;
    }

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Product> showAllItemsFromBasket(Client client){
        clientRepository.findById(client.getClientId()).orElseThrow(() -> new ClientNotFoundException(client.getClientId()));
        return client.getClientProductList();
    }
    public void addItemToBasket(Product product, Client client){
        clientRepository.findById(client.getClientId()).orElseThrow(() -> new ClientNotFoundException(client.getClientId()));
        client.addProductToBasket(product);
    }
    public void removeItemFromBasket(Product product, Client client){
        clientRepository.findById(client.getClientId()).orElseThrow(() -> new ClientNotFoundException(client.getClientId()));
        client.removeProductFromBasket(product);
    }
}
