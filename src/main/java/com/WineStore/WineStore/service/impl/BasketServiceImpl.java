package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.BasketDto;
import com.WineStore.WineStore.dto.CustomerDto;
import com.WineStore.WineStore.exeption.BasketNotFoundException;
import com.WineStore.WineStore.mapper.BasketMapper;
import com.WineStore.WineStore.mapper.CustomerMapper;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.repository.BasketRepository;
import com.WineStore.WineStore.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final CustomerMapper customerMapper;
    private final BasketMapper basketMapper;

    @Override
    public Basket getCurrentBasketByCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public Basket getBasketById(Long id) {
        return basketRepository.getFirstById(id).get();
    }
}
