package com.WineStore.WineStore.mapper.impl.requestMapper;

import com.WineStore.WineStore.dto.requestDto.BasketRequestDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.CustomerUIMapper;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BasketRequestMapper implements Mapper<Basket, BasketRequestDto> {
    private final CustomerService customerService;
    private final CustomerUIMapper customerUIMapper;

    @Override
    public BasketRequestDto mapToDto(Basket basket) {
        return null;
    }

    @Override
    public Basket mapToModel(BasketRequestDto basketRequestDto) {
        Basket basket = new Basket();
        basket.setCustomer(customerUIMapper.mapToModel(
                customerService.getById(basketRequestDto.getCustomerId())));
        return basket;
    }
}
