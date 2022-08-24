package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.BasketCreateDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Basket;
import org.springframework.stereotype.Component;

@Component
public class BasketCreateMapper implements Mapper<Basket, BasketCreateDto> {

    @Override
    public BasketCreateDto mapToDto(Basket basket) {
        return null;
    }

    @Override
    public Basket mapToModel(BasketCreateDto basketCreateDto) {
        return null;
    }
}
