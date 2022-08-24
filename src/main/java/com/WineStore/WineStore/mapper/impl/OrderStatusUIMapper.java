package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.OrderStatusUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusUIMapper implements Mapper<OrderStatus, OrderStatusUIDto> {

    @Override
    public OrderStatusUIDto mapToDto(OrderStatus orderStatus) {
        return OrderStatusUIDto.builder()
                .id(orderStatus.getId())
                .name(orderStatus.getName())
                .build();
    }

    @Override
    public OrderStatus mapToModel(OrderStatusUIDto orderStatusUIDto) {
        return null;
    }
}
