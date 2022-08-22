package com.WineStore.WineStore.mapper;

import com.WineStore.WineStore.dto.BasketDto;
import com.WineStore.WineStore.dto.OrderCreateDto;
import com.WineStore.WineStore.model.Order;
import com.WineStore.WineStore.service.BasketService;
import com.WineStore.WineStore.service.OrderStatusService;
import com.WineStore.WineStore.service.impl.BasketServiceImpl;
import liquibase.pro.packaged.A;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderCreateMapper implements Mapper<Order, OrderCreateDto>{
    private final BasketService basketService;
    private final OrderStatusService orderStatusService;

    @Override
    public OrderCreateDto mapToDto(Order order) {
        return null;
    }

    @Override
    public Order mapToModel(OrderCreateDto orderCreateDto) {
        Order order = new Order();

        order.setBasket2(basketService.getBasketById(orderCreateDto.getBasketId()));
        order.setOrderDate(orderCreateDto.getOrderDate());
        order.setShippedDate(orderCreateDto.getShippedDate());
        order.setStatus(orderStatusService.getOrderStatusByName(
                orderCreateDto.getOrderStatusDto().getName()));

        return order;
    }
}
