package com.example.MarketShop.Exceptions.Basket;

public class BasketNotFoundException extends RuntimeException{
    public BasketNotFoundException(long id){
        super("Could not basket product by id: " + id);
    }
}
