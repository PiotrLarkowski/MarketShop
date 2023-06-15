package com.example.MarketShop.Exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(long id){
        super("Could not find product by id: " + id);
    }
}
