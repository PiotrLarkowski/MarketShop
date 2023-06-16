package com.example.MarketShop.Exceptions.Client;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(long id){
        super("Could not client product by id: " + id);
    }
}
