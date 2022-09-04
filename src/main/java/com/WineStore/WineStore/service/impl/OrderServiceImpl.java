package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.OrderRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderUIDto;
import com.WineStore.WineStore.exeption.OrderNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.OrderRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.OrderUIMapper;
import com.WineStore.WineStore.model.Order;
import com.WineStore.WineStore.repository.OrderRepository;
import com.WineStore.WineStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderUIMapper orderUIMapper;
    private final OrderRequestMapper orderRequestMapper;

    @Override
    public OrderUIDto create(OrderRequestDto orderRequestDto) {
        return orderUIMapper.mapToDto(orderRepository.save(
                orderRequestMapper.mapToModel(orderRequestDto)));
    }

    @Override
    public Order getById(long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrderByCustomer(long customer_id) {
        return orderRepository.getOrderByCustomer(customer_id);
    }
}
