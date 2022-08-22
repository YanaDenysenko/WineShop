package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.model.OrderStatus;
import com.WineStore.WineStore.repository.OrderStatusRepository;
import com.WineStore.WineStore.service.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    private final OrderStatusRepository orderStatusRepository;

    @Override
    public OrderStatus getOrderStatusByName(String name) {
        return orderStatusRepository.getOrderStatusByName(name).get();
    }
}
