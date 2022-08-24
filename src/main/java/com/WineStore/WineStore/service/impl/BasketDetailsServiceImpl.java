package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.BasketDetailsCreateDto;
import com.WineStore.WineStore.dto.BasketDetailsUIDto;
import com.WineStore.WineStore.dto.ProductDto;
import com.WineStore.WineStore.mapper.impl.BasketDetailsUIMapper;
import com.WineStore.WineStore.mapper.impl.BasketDetailsCreateMapper;
import com.WineStore.WineStore.mapper.impl.ProductMapper;
import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.repository.BasketDetailsRepository;
import com.WineStore.WineStore.service.BasketDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class BasketDetailsServiceImpl implements BasketDetailsService {
    private final BasketDetailsRepository basketDetailsRepository;
    private final ProductMapper productMapper;
    private final BasketDetailsUIMapper basketDetailsUIMapper;
    private final BasketDetailsCreateMapper basketDetailsCreateMapper;

    @Override
    public BasketDetails save(BasketDetails basketDetails) {
        return null;
    }

    @Override
    public Optional<BasketDetails> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void delete(BasketDetails basketDetails) {
    }

    @Override
    public List<BasketDetails> findAll() {
        return null;
    }

    @Override
    public Set<BasketDetails> getAllByProduct(ProductDto productDto) {
        return basketDetailsRepository.getAllByProduct(productMapper.mapToModel(productDto));
    }

    @Override
    public BasketDetailsUIDto create(BasketDetailsCreateDto basketDetailsCreateDto) {
        return basketDetailsUIMapper.mapToDto(basketDetailsRepository.save(
                basketDetailsCreateMapper.mapToModel(basketDetailsCreateDto)));
    }
}
