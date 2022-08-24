package com.WineStore.WineStore.exeption;

public class ProductCategoryNotFoundException extends RuntimeException{

    public ProductCategoryNotFoundException(String name){
        super("Product category \"" + name + "\" - not found!");
    }
}
