package com.WineStore.WineStore.exeption;

public class CurrentBasketNotFoundException extends RuntimeException{

    public CurrentBasketNotFoundException(long customerId) {
        super("Current basket for customer with id \"" + customerId + "\" - not found!");
    }
}
