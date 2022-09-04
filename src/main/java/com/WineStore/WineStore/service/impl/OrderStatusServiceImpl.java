package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.OrderStatusRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderStatusUIDto;
import com.WineStore.WineStore.exeption.OrderStatusNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.OrderStatusRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.OrderStatusUIMapper;
import com.WineStore.WineStore.model.OrderStatus;
import com.WineStore.WineStore.repository.OrderStatusRepository;
import com.WineStore.WineStore.service.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    private final OrderStatusRepository orderStatusRepository;
    private final OrderStatusRequestMapper orderStatusRequestMapper;
    private final OrderStatusUIMapper orderStatusUIMapper;

    @Override
    public OrderStatusUIDto create(OrderStatusRequestDto orderStatusRequestDto) {
        return orderStatusUIMapper.mapToDto(orderStatusRepository.save(
                orderStatusRequestMapper.mapToModel(orderStatusRequestDto)));
    }

    @Override
    public OrderStatus getById(long id) {
        return orderStatusRepository.findById(id)
                .orElseThrow(() -> new OrderStatusNotFoundException(String.valueOf(id)));
    }

    @Override
    public List<OrderStatus> getAll() {
        return orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus getByName(String name) {
        return orderStatusRepository.getOrderStatusByName(name)
                .orElseThrow(() -> new OrderStatusNotFoundException(name));
    }
}
