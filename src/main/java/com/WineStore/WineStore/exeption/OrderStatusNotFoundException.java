package com.WineStore.WineStore.exeption;

public class OrderStatusNotFoundException extends RuntimeException {
    public OrderStatusNotFoundException(String name){
        super("Order status \"" + name + "\" not found!");
    }
}
