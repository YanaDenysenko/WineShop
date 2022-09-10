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
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

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
    public OrderStatusUIDto updateById(OrderStatusRequestDto orderStatusRequestDto, long id) {
        OrderStatus orderStatus = orderStatusRepository.findById(id)
                .orElseThrow(() -> new OrderStatusNotFoundException(String.valueOf(id)));

        orderStatus.setName(orderStatusRequestDto.getName());
        orderStatus.setModified(new Timestamp(System.currentTimeMillis()));

        return orderStatusUIMapper.mapToDto(orderStatusRepository.save(orderStatus));
    }

    @Override
    public OrderStatusUIDto deleteById(long id) {
        OrderStatus orderStatus = orderStatusRepository.findById(id)
                .orElseThrow(() -> new OrderStatusNotFoundException(String.valueOf(id)));

        orderStatus.setDeleted(true);
        orderStatus.setModified(new Timestamp(System.currentTimeMillis()));

        return orderStatusUIMapper.mapToDto(orderStatusRepository.save(orderStatus));
    }

    @Override
    public OrderStatusUIDto getById(long id) {
        return orderStatusUIMapper.mapToDto(orderStatusRepository.findById(id)
                .orElseThrow(() -> new OrderStatusNotFoundException(String.valueOf(id))));
    }

    @Override
    public List<OrderStatusUIDto> getAll() {
        return orderStatusRepository.findAll().stream()
                .map(orderStatusUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderStatusUIDto getByName(String name) {
        return orderStatusUIMapper.mapToDto(orderStatusRepository.getOrderStatusByName(name)
                .orElseThrow(() -> new OrderStatusNotFoundException(name)));
    }
}
