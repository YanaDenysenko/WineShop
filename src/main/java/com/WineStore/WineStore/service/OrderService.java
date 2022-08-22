package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.CustomerDto;
import com.WineStore.WineStore.dto.OrderCreateDto;
import com.WineStore.WineStore.dto.OrderUIDto;
import com.WineStore.WineStore.model.Product;

import java.util.Set;

public interface OrderService {
    Set<Product> getOrderByCustomer (CustomerDto customerDto);

    OrderUIDto create (OrderCreateDto orderCreateDto);
}
