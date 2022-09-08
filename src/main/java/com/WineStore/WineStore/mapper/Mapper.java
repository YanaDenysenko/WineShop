package com.WineStore.WineStore.mapper;

public interface Mapper <M,D> {
    D mapToDto(M m);

    M mapToModel(D d);
}
