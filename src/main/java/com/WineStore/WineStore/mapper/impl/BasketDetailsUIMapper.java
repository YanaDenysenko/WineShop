package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.BasketDetailsUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.BasketDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BasketDetailsUIMapper implements Mapper<BasketDetails, BasketDetailsUIDto> {
    ProductMapper productMapper;
    BasketMapper basketMapper;

    @Override
    public BasketDetailsUIDto mapToDto(BasketDetails basketDetails) {
        return BasketDetailsUIDto.builder()
                .id(basketDetails.getId())
                .product(productMapper.mapToDto(basketDetails.getProduct()))
                .basket(basketMapper.mapToDto(basketDetails.getBasket()))
                .quantity(basketDetails.getQuantity())
                .build();
    }

    @Override
    public BasketDetails mapToModel(BasketDetailsUIDto basketDetailsUIDto) {
        return null;
    }
}
