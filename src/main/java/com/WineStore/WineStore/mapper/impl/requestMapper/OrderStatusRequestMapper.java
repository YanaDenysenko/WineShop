package com.WineStore.WineStore.mapper.impl.requestMapper;

import com.WineStore.WineStore.dto.requestDto.OrderStatusRequestDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusRequestMapper implements Mapper<OrderStatus, OrderStatusRequestDto> {

    @Override
    public OrderStatusRequestDto mapToDto(OrderStatus orderStatus) {
        return null;
    }

    @Override
    public OrderStatus mapToModel(OrderStatusRequestDto orderStatusRequestDto) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setName(orderStatusRequestDto.getName());
        return orderStatus;
    }
}
