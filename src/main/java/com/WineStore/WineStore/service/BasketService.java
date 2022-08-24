package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.BasketRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketUIDto;
import com.WineStore.WineStore.model.Basket;
import java.util.List;

public interface BasketService {

    BasketUIDto create(BasketRequestDto basketRequestDto);

    Basket getById(long id);

    List<Basket> getAll();

    void deleteById(long id);

    BasketUIDto updateById(BasketRequestDto basketRequestDto, long id);

    Basket getCurrentBasketByCustomer(long customerId);
}
