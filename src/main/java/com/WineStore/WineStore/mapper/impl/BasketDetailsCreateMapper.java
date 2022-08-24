package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.BasketDetailsCreateDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.service.BasketService;
import com.WineStore.WineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BasketDetailsCreateMapper implements Mapper<BasketDetails, BasketDetailsCreateDto> {
    ProductService productService;
    BasketService basketService;

    @Override
    public BasketDetailsCreateDto mapToDto(BasketDetails basketDetails) {
        return null;
    }

    @Override
    public BasketDetails mapToModel(BasketDetailsCreateDto basketDetailsCreateDto) {
        BasketDetails basketDetails = new BasketDetails();
        basketDetails.setProduct(productService.findById(basketDetailsCreateDto.getProductId()));
        basketDetails.setBasket(basketService.findById(basketDetailsCreateDto.getBasketId()));
        basketDetails.setQuantity(basketDetailsCreateDto.getQuantity());
        return basketDetails;
    }
}
