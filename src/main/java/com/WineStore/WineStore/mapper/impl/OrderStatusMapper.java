package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.OrderStatusDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusMapper implements Mapper<OrderStatus, OrderStatusDto> {

    @Override
    public OrderStatusDto mapToDto(OrderStatus orderStatus) {
        return null;
    }

    @Override
    public OrderStatus mapToModel(OrderStatusDto orderStatusDto) {
        return null;
    }
}
