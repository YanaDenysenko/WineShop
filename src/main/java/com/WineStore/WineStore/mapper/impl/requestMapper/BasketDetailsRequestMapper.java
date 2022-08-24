package com.WineStore.WineStore.mapper.impl.requestMapper;

import com.WineStore.WineStore.dto.requestDto.BasketDetailsRequestDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.service.BasketService;
import com.WineStore.WineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BasketDetailsRequestMapper implements Mapper<BasketDetails, BasketDetailsRequestDto> {
    ProductService productService;
    BasketService basketService;

    @Override
    public BasketDetailsRequestDto mapToDto(BasketDetails basketDetails) {
        return null;
    }

    @Override
    public BasketDetails mapToModel(BasketDetailsRequestDto basketDetailsRequestDto) {
        BasketDetails basketDetails = new BasketDetails();
        basketDetails.setProduct(productService.getById(basketDetailsRequestDto.getProductId()));
        basketDetails.setBasket(basketService.getById(basketDetailsRequestDto.getBasketId()));
        basketDetails.setQuantity(basketDetailsRequestDto.getQuantity());
        return basketDetails;
    }
}
