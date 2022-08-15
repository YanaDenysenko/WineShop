package com.WineStore.WineStore.mapper;

public interface Mapper <D,M>{
    D mapToDto(M m);

    M mapToModel(D d);
}
