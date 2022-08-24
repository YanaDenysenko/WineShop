package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.OrderStatusRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderStatusUIDto;
import com.WineStore.WineStore.model.OrderStatus;
import java.util.List;

public interface OrderStatusService {

    OrderStatusUIDto create(OrderStatusRequestDto orderStatusRequestDto);

    OrderStatus getById(long id);

    List<OrderStatus> getAll();

    OrderStatus getOrderStatusByName(String name);
}
