package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.BasketDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Basket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BasketMapper implements Mapper<Basket, BasketDto> {

    @Override
    public BasketDto mapToDto(Basket basket) {
        return null;
    }

    @Override
    public Basket mapToModel(BasketDto basketDto) {
        return null;
    }
}
