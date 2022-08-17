package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.CustomerDto;
import com.WineStore.WineStore.mapper.CustomerMapper;
import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.repository.OrderRepository;
import com.WineStore.WineStore.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    CustomerMapper customerMapper;

    @Override
    public Set<Product> getOrderByCustomer(CustomerDto customerDto) {
        return null;
    }
}
