package com.example.MarketShop.Services;

import com.example.MarketShop.Domain.Client;
import com.example.MarketShop.Domain.Product;
import com.example.MarketShop.Exceptions.Client.ClientNotFoundException;
import com.example.MarketShop.Repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Product> showAllItemsFromBasket(Client client){
        clientRepository.findById(client.getClientId()).orElseThrow(() -> new ClientNotFoundException(client.getClientId()));
        return client.getClientBasket().getSelectedProducts();
    }
    public void addItemToBasket(Product product, Client client){
        clientRepository.findById(client.getClientId()).orElseThrow(() -> new ClientNotFoundException(client.getClientId()));
        client.getClientBasket().addProduct(product);
    }
    public void removeItemFromBasket(Product product, Client client){
        clientRepository.findById(client.getClientId()).orElseThrow(() -> new ClientNotFoundException(client.getClientId()));
        client.getClientBasket().removeProduct(product);
    }
}
