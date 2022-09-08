package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.OrderStatusRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderStatusUIDto;
import java.util.List;

public interface OrderStatusService {

    OrderStatusUIDto create(OrderStatusRequestDto orderStatusRequestDto);

    OrderStatusUIDto updateById(OrderStatusRequestDto orderStatusRequestDto, long id);

    OrderStatusUIDto deleteById(long id);

    OrderStatusUIDto getById(long id);

    List<OrderStatusUIDto> getAll();

    OrderStatusUIDto getByName(String name);
}
