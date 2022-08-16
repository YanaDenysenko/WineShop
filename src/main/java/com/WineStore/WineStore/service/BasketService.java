package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.CustomerDto;
import com.WineStore.WineStore.model.Basket;

public interface BasketService {
    Basket getCurrentBasketByCustomer(CustomerDto customerDto);
}
