package com.WineStore.WineStore.exeption;

public class BasketDetailsNotFountException extends RuntimeException{

    public BasketDetailsNotFountException(long id){
        super("Basket details with id \"" + id + "\" - not found!");
    }
}
