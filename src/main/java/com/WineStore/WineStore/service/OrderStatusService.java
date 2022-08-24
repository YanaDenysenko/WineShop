package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.OrderStatusCreateDto;
import com.WineStore.WineStore.dto.OrderStatusUIDto;
import com.WineStore.WineStore.model.OrderStatus;

public interface OrderStatusService {
    OrderStatus getOrderStatusByName(String name);

    OrderStatusUIDto create(OrderStatusCreateDto orderStatusCreateDto);
}
