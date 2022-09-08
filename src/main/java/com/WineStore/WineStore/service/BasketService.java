package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.BasketRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketUIDto;
import java.util.List;

public interface BasketService {

    BasketUIDto create(BasketRequestDto basketRequestDto);

    BasketUIDto updateById(BasketRequestDto basketRequestDto, long id);

    BasketUIDto getById(long id);

    List<BasketUIDto> getAll();

    void deleteById(long id);

    BasketUIDto getCurrentBasketByCustomer(long customerId);
}
