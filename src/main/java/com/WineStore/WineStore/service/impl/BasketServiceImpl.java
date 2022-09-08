package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.BasketRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketUIDto;
import com.WineStore.WineStore.exeption.BasketNotFoundException;
import com.WineStore.WineStore.exeption.CurrentBasketNotFoundException;
import com.WineStore.WineStore.exeption.CustomerNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.BasketRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.BasketUIMapper;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.repository.BasketRepository;
import com.WineStore.WineStore.repository.CustomerRepository;
import com.WineStore.WineStore.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BasketUIMapper basketUIMapper;
    private final BasketRequestMapper basketRequestMapper;
    private final CustomerRepository customerRepository;

    @Override
    public BasketUIDto create(BasketRequestDto basketRequestDto) {
        return basketUIMapper.mapToDto(basketRepository.save(
                basketRequestMapper.mapToModel(basketRequestDto)));
    }

    @Override
    public BasketUIDto updateById(BasketRequestDto basketRequestDto, long id) {
        long customerId = basketRequestDto.getCustomerId();
        Basket basket = basketRepository.findById(id)
                .orElseThrow(() -> new BasketNotFoundException(id));

        basket.setCustomer(customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId)));
        basket.setModified(new Timestamp(System.currentTimeMillis()));

        return basketUIMapper.mapToDto(basketRepository.save(basket));
    }

    @Override
    public BasketUIDto getById(long id) {
        return basketUIMapper.mapToDto(basketRepository.findById(id)
                .orElseThrow(() -> new BasketNotFoundException(id)));
    }

    @Override
    public List<BasketUIDto> getAll() {
        return basketRepository.findAll().stream()
                .map(basketUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        basketRepository.deleteById(id);
    }

    @Override
    public BasketUIDto getCurrentBasketByCustomer(long customerId) {
        return basketUIMapper.mapToDto(basketRepository.getCurrentBasketByCustomer(customerId)
                .orElseThrow(() -> new CurrentBasketNotFoundException(customerId)));
    }
}
