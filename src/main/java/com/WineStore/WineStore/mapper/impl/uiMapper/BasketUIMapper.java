package com.WineStore.WineStore.mapper.impl.uiMapper;

import com.WineStore.WineStore.dto.uiDto.BasketUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Basket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BasketUIMapper implements Mapper<Basket, BasketUIDto> {
    CustomerUIMapper customerUIMapper;

    @Override
    public BasketUIDto mapToDto(Basket basket) {
        return BasketUIDto.builder()
                .id(basket.getId())
                .customerUIDto(customerUIMapper.mapToDto(basket.getCustomer()))
                .build();
    }

    @Override
    public Basket mapToModel(BasketUIDto basketUIDto) {
        return null;
    }
}
