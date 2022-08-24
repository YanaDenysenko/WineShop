package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.BasketCreateDto;
import com.WineStore.WineStore.dto.BasketUIDto;
import com.WineStore.WineStore.dto.CustomerDto;
import com.WineStore.WineStore.exeption.BasketNotFoundException;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.repository.BasketRepository;
import com.WineStore.WineStore.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;

    @Override
    public Basket getCurrentBasketByCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public Basket getBasketById(Long id) {
        return basketRepository.getFirstById(id)
                .orElseThrow(() -> new BasketNotFoundException(id));
    }

    @Override
    public BasketUIDto create(BasketCreateDto basketCreateDto) {
        return null;
    }
}
