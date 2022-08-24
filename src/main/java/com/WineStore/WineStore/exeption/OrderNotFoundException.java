package com.WineStore.WineStore.exeption;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(long id){
        super("Order with id \"" + id + "\" - not found!");
    }
}
