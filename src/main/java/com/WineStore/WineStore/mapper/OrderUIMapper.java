package com.WineStore.WineStore.mapper;

import com.WineStore.WineStore.dto.OrderUIDto;
import com.WineStore.WineStore.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderUIMapper implements Mapper<Order, OrderUIDto>{
    private final BasketMapper basketMapper;
    private final OrderStatusMapper orderStatusMapper;

    @Override
    public OrderUIDto mapToDto(Order order) {
        return OrderUIDto.builder()
                .id(order.getId())
                .basket(basketMapper.mapToDto(order.getBasket()))
                .orderDate(order.getOrderDate())
                .shippedDate(order.getShippedDate())
                .status(orderStatusMapper.mapToDto(order.getStatus()))
                .build();
    }

    @Override
    public Order mapToModel(OrderUIDto orderDto) {
        return null;
    }
}
