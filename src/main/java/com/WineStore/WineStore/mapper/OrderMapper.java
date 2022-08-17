package com.WineStore.WineStore.mapper;

import com.WineStore.WineStore.dto.OrderDto;
import com.WineStore.WineStore.model.Order;

public class OrderMapper implements Mapper<Order, OrderDto>{
    @Override
    public OrderDto mapToDto(Order order) {
        return null;
    }

    @Override
    public Order mapToModel(OrderDto orderDto) {
        return null;
    }
}
