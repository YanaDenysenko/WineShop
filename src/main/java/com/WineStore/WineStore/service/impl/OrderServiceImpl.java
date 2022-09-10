package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.OrderRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderUIDto;
import com.WineStore.WineStore.exeption.BasketNotFoundException;
import com.WineStore.WineStore.exeption.OrderNotFoundException;
import com.WineStore.WineStore.exeption.OrderStatusNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.OrderRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.OrderUIMapper;
import com.WineStore.WineStore.model.Order;
import com.WineStore.WineStore.repository.BasketRepository;
import com.WineStore.WineStore.repository.OrderRepository;
import com.WineStore.WineStore.repository.OrderStatusRepository;
import com.WineStore.WineStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderUIMapper orderUIMapper;
    private final OrderRequestMapper orderRequestMapper;
    private final BasketRepository basketRepository;
    private final OrderStatusRepository orderStatusRepository;

    @Override
    public OrderUIDto create(OrderRequestDto orderRequestDto) {
        return orderUIMapper.mapToDto(orderRepository.save(
                orderRequestMapper.mapToModel(orderRequestDto)));
    }

    @Override
    public OrderUIDto updateById(OrderRequestDto orderRequestDto, long id) {
        long basketId = orderRequestDto.getBasketId();
        long statusId = orderRequestDto.getOrderStatusId();
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        order.setBasket(basketRepository.findById(basketId)
                .orElseThrow(() -> new BasketNotFoundException(basketId)));
        order.setOrderDate(orderRequestDto.getOrderDate());
        order.setShippedDate(orderRequestDto.getShippedDate());
        order.setStatus(orderStatusRepository.findById(statusId)
                .orElseThrow(() -> new OrderStatusNotFoundException(String.valueOf(statusId))));
        order.setModified(new Timestamp(System.currentTimeMillis()));

        return orderUIMapper.mapToDto(orderRepository.save(order));
    }

    @Override
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderUIDto getById(long id) {
        return orderUIMapper.mapToDto(orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id)));
    }

    @Override
    public List<OrderUIDto> getAll() {
        return orderRepository.findAll().stream()
                .map(orderUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderUIDto> getOrderByCustomer(long customer_id) {
        return orderRepository.getOrderByCustomer(customer_id).stream()
                .map(orderUIMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
