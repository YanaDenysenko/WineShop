package com.WineStore.WineStore.exeption;

public class BasketNotFoundException extends RuntimeException{
    public BasketNotFoundException(){
        super("Basket not found!");
    }
}
