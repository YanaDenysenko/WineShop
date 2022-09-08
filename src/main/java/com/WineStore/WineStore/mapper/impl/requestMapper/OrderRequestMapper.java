package com.WineStore.WineStore.mapper.impl.requestMapper;

import com.WineStore.WineStore.dto.requestDto.OrderRequestDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.BasketUIMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.OrderStatusUIMapper;
import com.WineStore.WineStore.model.Order;
import com.WineStore.WineStore.service.BasketService;
import com.WineStore.WineStore.service.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderRequestMapper implements Mapper<Order, OrderRequestDto> {
    private final BasketService basketService;
    private final OrderStatusService orderStatusService;
    private final BasketUIMapper basketUIMapper;
    private final OrderStatusUIMapper orderStatusUIMapper;

    @Override
    public OrderRequestDto mapToDto(Order order) {
        return null;
    }

    @Override
    public Order mapToModel(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setBasket(basketUIMapper.mapToModel(basketService.getById(
                orderRequestDto.getBasketId())));
        order.setOrderDate(orderRequestDto.getOrderDate());
        order.setShippedDate(orderRequestDto.getShippedDate());
        order.setStatus(orderStatusUIMapper.mapToModel(orderStatusService.getById(
                orderRequestDto.getOrderStatusId())));
        return order;
    }
}
