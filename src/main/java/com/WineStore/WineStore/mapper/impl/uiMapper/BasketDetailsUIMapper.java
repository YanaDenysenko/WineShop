package com.WineStore.WineStore.mapper.impl.uiMapper;

import com.WineStore.WineStore.dto.uiDto.BasketDetailsUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.BasketDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BasketDetailsUIMapper implements Mapper<BasketDetails, BasketDetailsUIDto> {
    ProductUIMapper productUIMapper;
    BasketUIMapper basketUIMapper;

    @Override
    public BasketDetailsUIDto mapToDto(BasketDetails basketDetails) {
        return BasketDetailsUIDto.builder()
                .id(basketDetails.getId())
                .productUIDto(productUIMapper.mapToDto(basketDetails.getProduct()))
                .basketUIDto(basketUIMapper.mapToDto(basketDetails.getBasket()))
                .quantity(basketDetails.getQuantity())
                .build();
    }

    @Override
    public BasketDetails mapToModel(BasketDetailsUIDto basketDetailsUIDto) {
        return null;
    }
}
