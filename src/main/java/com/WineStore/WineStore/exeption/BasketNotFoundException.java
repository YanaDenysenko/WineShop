package com.WineStore.WineStore.exeption;

public class BasketNotFoundException extends RuntimeException{

    public BasketNotFoundException(long id){
        super("Basket with id \"" + id + "\"not found!");
    }
}
