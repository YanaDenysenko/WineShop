package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.BasketDetailsRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketDetailsUIDto;
import com.WineStore.WineStore.exeption.BasketDetailsNotFountException;
import com.WineStore.WineStore.exeption.BasketNotFoundException;
import com.WineStore.WineStore.exeption.ProductNotFoundException;
import com.WineStore.WineStore.mapper.impl.uiMapper.BasketDetailsUIMapper;
import com.WineStore.WineStore.mapper.impl.requestMapper.BasketDetailsRequestMapper;
import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.repository.BasketDetailsRepository;
import com.WineStore.WineStore.repository.BasketRepository;
import com.WineStore.WineStore.repository.ProductRepository;
import com.WineStore.WineStore.service.BasketDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BasketDetailsServiceImpl implements BasketDetailsService {
    private final BasketDetailsRepository basketDetailsRepository;
    private final BasketDetailsUIMapper basketDetailsUIMapper;
    private final BasketDetailsRequestMapper basketDetailsRequestMapper;
    private final ProductRepository productRepository;
    private final BasketRepository basketRepository;

    @Override
    public BasketDetailsUIDto create(BasketDetailsRequestDto basketDetailsRequestDto) {
        return basketDetailsUIMapper.mapToDto(basketDetailsRepository.save(
                basketDetailsRequestMapper.mapToModel(basketDetailsRequestDto)));
    }

    public BasketDetailsUIDto updateById(BasketDetailsRequestDto basketDetailsRequestDto, long id) {
        long productId = basketDetailsRequestDto.getProductId();
        long basketId = basketDetailsRequestDto.getBasketId();
        BasketDetails basketDetails = basketDetailsRepository.findById(id)
                .orElseThrow(() -> new BasketDetailsNotFountException(id));

        basketDetails.setProduct(productRepository.findById(basketId)
                .orElseThrow(() -> new ProductNotFoundException(productId)));
        basketDetails.setBasket(basketRepository.findById(basketId)
                .orElseThrow(() -> new BasketNotFoundException(basketId)));
        basketDetails.setQuantity(basketDetailsRequestDto.getQuantity());
        basketDetails.setModified(new Timestamp(System.currentTimeMillis()));

        return basketDetailsUIMapper.mapToDto(basketDetailsRepository.save(basketDetails));
    }

    @Override
    public void deleteById(long id) {
        basketDetailsRepository.deleteById(id);
    }

    @Override
    public BasketDetailsUIDto getById(long id) {
        return basketDetailsUIMapper.mapToDto(basketDetailsRepository.findById(id)
                .orElseThrow(() -> new BasketDetailsNotFountException(id)));
    }

    @Override
    public List<BasketDetailsUIDto> getAll() {
        return basketDetailsRepository.findAll().stream()
                .map(basketDetailsUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BasketDetailsUIDto> getAllByProduct(long productId) {
        return basketDetailsRepository.getAllByProduct(productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId))).stream()
                .map(basketDetailsUIMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
