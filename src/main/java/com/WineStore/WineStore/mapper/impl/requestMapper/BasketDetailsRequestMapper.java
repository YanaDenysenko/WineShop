package com.WineStore.WineStore.mapper.impl.requestMapper;

import com.WineStore.WineStore.dto.requestDto.BasketDetailsRequestDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.BasketUIMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.ProductUIMapper;
import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.service.BasketService;
import com.WineStore.WineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BasketDetailsRequestMapper implements Mapper<BasketDetails, BasketDetailsRequestDto> {
    private final ProductService productService;
    private final BasketService basketService;
    private final BasketUIMapper basketUIMapper;
    private final ProductUIMapper productUIMapper;

    @Override
    public BasketDetailsRequestDto mapToDto(BasketDetails basketDetails) {
        return null;
    }

    @Override
    public BasketDetails mapToModel(BasketDetailsRequestDto basketDetailsRequestDto) {
        BasketDetails basketDetails = new BasketDetails();
        basketDetails.setProduct(productUIMapper.mapToModel(productService.getById(
                basketDetailsRequestDto.getProductId())));
        basketDetails.setBasket(basketUIMapper.mapToModel(basketService.getById(
                basketDetailsRequestDto.getBasketId())));
        basketDetails.setQuantity(basketDetailsRequestDto.getQuantity());
        return basketDetails;
    }
}
