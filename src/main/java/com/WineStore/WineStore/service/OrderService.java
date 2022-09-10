package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.OrderRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderUIDto;
import java.util.List;

public interface OrderService {

    OrderUIDto create(OrderRequestDto orderRequestDto);

    OrderUIDto updateById(OrderRequestDto orderRequestDto, long id);

    void deleteById(long id);

    OrderUIDto getById(long id);

    List<OrderUIDto> getAll();

    List<OrderUIDto> getOrderByCustomer(long customer_id);
}
