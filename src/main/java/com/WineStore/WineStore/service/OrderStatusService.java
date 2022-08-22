package com.WineStore.WineStore.service;

import com.WineStore.WineStore.model.OrderStatus;

public interface OrderStatusService {
    OrderStatus getOrderStatusByName(String name);
}
