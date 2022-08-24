package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.OrderStatusCreateDto;
import com.WineStore.WineStore.dto.OrderStatusUIDto;
import com.WineStore.WineStore.exeption.OrderStatusNotFoundException;
import com.WineStore.WineStore.mapper.impl.OrderStatusCreateMapper;
import com.WineStore.WineStore.mapper.impl.OrderStatusUIMapper;
import com.WineStore.WineStore.model.OrderStatus;
import com.WineStore.WineStore.repository.OrderStatusRepository;
import com.WineStore.WineStore.service.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    private final OrderStatusRepository orderStatusRepository;
    private final OrderStatusCreateMapper orderStatusCreateMapper;
    private final OrderStatusUIMapper orderStatusUIMapper;

    @Override
    public OrderStatus getOrderStatusByName(String name) {
        return orderStatusRepository.getOrderStatusByName(name)
                .orElseThrow(() -> new OrderStatusNotFoundException(name));
    }

    @Override
    public OrderStatusUIDto create(OrderStatusCreateDto orderStatusCreateDto) {
        return orderStatusUIMapper.mapToDto(orderStatusRepository.save(
                orderStatusCreateMapper.mapToModel(orderStatusCreateDto)));
    }
}
