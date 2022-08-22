package com.WineStore.WineStore.exeption;

public class SessionFactoryConnectionException extends RuntimeException{

    public SessionFactoryConnectionException(String msg){
        super(msg);
    }
}
