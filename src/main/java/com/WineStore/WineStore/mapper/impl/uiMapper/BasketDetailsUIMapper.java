package com.WineStore.WineStore.mapper.impl.uiMapper;

import com.WineStore.WineStore.dto.uiDto.BasketDetailsUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.BasketDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BasketDetailsUIMapper implements Mapper<BasketDetails, BasketDetailsUIDto> {
    private final ProductUIMapper productUIMapper;
    private final BasketUIMapper basketUIMapper;

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
        BasketDetails basketDetails = new BasketDetails();
        basketDetails.setId(basketDetailsUIDto.getId());
        basketDetails.setProduct(productUIMapper.mapToModel(basketDetailsUIDto.getProductUIDto()));
        basketDetails.setBasket(basketUIMapper.mapToModel(basketDetailsUIDto.getBasketUIDto()));
        basketDetails.setQuantity(basketDetailsUIDto.getQuantity());
        return basketDetails;
    }
}
