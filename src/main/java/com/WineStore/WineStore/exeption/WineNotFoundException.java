package com.WineStore.WineStore.exeption;

public class WineNotFoundException extends RuntimeException{

    public WineNotFoundException(long id){
        super("Wine with id \"" + id + "\" - not found!");
    }
}
