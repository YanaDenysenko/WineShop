package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.CustomerDto;
import com.WineStore.WineStore.dto.OrderCreateDto;
import com.WineStore.WineStore.dto.OrderUIDto;
import com.WineStore.WineStore.mapper.OrderCreateMapper;
import com.WineStore.WineStore.mapper.OrderUIMapper;
import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.repository.OrderRepository;
import com.WineStore.WineStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderUIMapper orderUIMapper;
    private final OrderCreateMapper orderCreateMapper;


    @Override
    public Set<Product> getOrderByCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public OrderUIDto create(OrderCreateDto orderCreateDto) {
        return orderUIMapper.mapToDto(orderRepository.save(
                orderCreateMapper.mapToModel(orderCreateDto)));
    }
}
