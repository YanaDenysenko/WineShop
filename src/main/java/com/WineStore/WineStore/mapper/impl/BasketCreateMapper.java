package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.BasketCreateDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BasketCreateMapper implements Mapper<Basket, BasketCreateDto> {
    CustomerService customerService;

    @Override
    public BasketCreateDto mapToDto(Basket basket) {
        return null;
    }

    @Override
    public Basket mapToModel(BasketCreateDto basketCreateDto) {
        Basket basket = new Basket();
        basket.setCustomer(customerService.getCustomerById(basketCreateDto.getCustomerId()));
        return basket;
    }
}
