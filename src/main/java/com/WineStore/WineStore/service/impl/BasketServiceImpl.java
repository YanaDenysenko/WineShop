package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.CustomerDto;
import com.WineStore.WineStore.mapper.CustomerMapper;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.repository.BasketRepository;
import com.WineStore.WineStore.service.BasketService;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {
    BasketRepository basketRepository;
    CustomerMapper customerMapper;


    @Override
    public Basket getCurrentBasketByCustomer(CustomerDto customerDto) {
        return basketRepository.getCurrentBasketByCustomer(customerMapper.mapToModel(customerDto));
    }
}
