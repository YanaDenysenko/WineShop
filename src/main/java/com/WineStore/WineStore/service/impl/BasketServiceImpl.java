package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.BasketRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketUIDto;
import com.WineStore.WineStore.exeption.BasketNotFoundException;
import com.WineStore.WineStore.exeption.CurrentBasketNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.BasketRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.BasketUIMapper;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.repository.BasketRepository;
import com.WineStore.WineStore.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BasketUIMapper basketUIMapper;
    private final BasketRequestMapper basketRequestMapper;

    @Override
    public BasketUIDto create(BasketRequestDto basketRequestDto) {
        return basketUIMapper.mapToDto(basketRepository.save(
                basketRequestMapper.mapToModel(basketRequestDto)));
    }

    @Override
    public Basket getById(long id) {
        return basketRepository.findById(id)
                .orElseThrow(() -> new BasketNotFoundException(id));
    }

    @Override
    public List<Basket> getAll() {
        return basketRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        basketRepository.deleteById(id);
    }

    //TODO
    @Override
    public BasketUIDto updateById(BasketRequestDto basketRequestDto, long id) {
        return null;
    }

    @Override
    public Basket getCurrentBasketByCustomer(long customerId) {
        return basketRepository.getCurrentBasketByCustomer(customerId)
                .orElseThrow(() -> new CurrentBasketNotFoundException(customerId));
    }
}
