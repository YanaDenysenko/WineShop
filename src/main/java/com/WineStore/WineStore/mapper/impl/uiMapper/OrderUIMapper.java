package com.WineStore.WineStore.mapper.impl.uiMapper;

import com.WineStore.WineStore.dto.uiDto.OrderUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderUIMapper implements Mapper<Order, OrderUIDto> {
    private final BasketUIMapper basketUIMapper;
    private final OrderStatusUIMapper orderStatusUIMapper;

    @Override
    public OrderUIDto mapToDto(Order order) {
        return OrderUIDto.builder()
                .id(order.getId())
                .basketUIDto(basketUIMapper.mapToDto(order.getBasket()))
                .orderDate(order.getOrderDate())
                .shippedDate(order.getShippedDate())
                .orderStatusUIDto(orderStatusUIMapper.mapToDto(order.getStatus()))
                .build();
    }

    @Override
    public Order mapToModel(OrderUIDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setBasket(basketUIMapper.mapToModel(orderDto.getBasketUIDto()));
        order.setOrderDate(orderDto.getOrderDate());
        order.setShippedDate(orderDto.getShippedDate());
        order.setStatus(orderStatusUIMapper.mapToModel(orderDto.getOrderStatusUIDto()));
        return order;
    }
}
