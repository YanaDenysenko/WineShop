package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.BasketCreateDto;
import com.WineStore.WineStore.dto.BasketUIDto;
import com.WineStore.WineStore.dto.CustomerDto;
import com.WineStore.WineStore.exeption.BasketNotFoundException;
import com.WineStore.WineStore.mapper.impl.BasketCreateMapper;
import com.WineStore.WineStore.mapper.impl.BasketUIMapper;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.repository.BasketRepository;
import com.WineStore.WineStore.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BasketUIMapper basketUIMapper;
    private final BasketCreateMapper basketCreateMapper;

    @Override
    public Basket getCurrentBasketByCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public Basket findById(long id) {
        return basketRepository.findById(id)
                .orElseThrow(() -> new BasketNotFoundException(id));
    }

    @Override
    public BasketUIDto create(BasketCreateDto basketCreateDto) {
        return basketUIMapper.mapToDto(basketRepository.save(
                basketCreateMapper.mapToModel(basketCreateDto)));
    }
}
