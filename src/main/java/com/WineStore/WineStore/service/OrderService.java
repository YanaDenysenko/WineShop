package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.OrderRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderUIDto;
import com.WineStore.WineStore.model.Order;
import java.util.List;

public interface OrderService {

    OrderUIDto create (OrderRequestDto orderRequestDto);

    Order getById(long id);

    List<Order> getAll();

    List<Order> getOrderByCustomer(long customer_id);
}
