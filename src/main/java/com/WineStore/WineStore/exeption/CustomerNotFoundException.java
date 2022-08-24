package com.WineStore.WineStore.exeption;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(long id){
        super("Customer with id \"" + id + "\" - not found!");
    }
}
