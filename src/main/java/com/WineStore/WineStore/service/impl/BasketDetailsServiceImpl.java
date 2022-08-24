package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.BasketDetailsRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketDetailsUIDto;
import com.WineStore.WineStore.exeption.BasketDetailsNotFountException;
import com.WineStore.WineStore.mapper.impl.uiMapper.BasketDetailsUIMapper;
import com.WineStore.WineStore.mapper.impl.requestMapper.BasketDetailsRequestMapper;
import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.repository.BasketDetailsRepository;
import com.WineStore.WineStore.service.BasketDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class BasketDetailsServiceImpl implements BasketDetailsService {
    private final BasketDetailsRepository basketDetailsRepository;
    private final BasketDetailsUIMapper basketDetailsUIMapper;
    private final BasketDetailsRequestMapper basketDetailsRequestMapper;

    @Override
    public BasketDetailsUIDto create(BasketDetailsRequestDto basketDetailsRequestDto) {
        return basketDetailsUIMapper.mapToDto(basketDetailsRepository.save(
                basketDetailsRequestMapper.mapToModel(basketDetailsRequestDto)));
    }

    @Override
    public BasketDetails getById(long id) {
        return basketDetailsRepository.findById(id)
                .orElseThrow(() -> new BasketDetailsNotFountException(id));
    }

    @Override
    public List<BasketDetails> getAll() {
        return basketDetailsRepository.findAll();
    }
}
