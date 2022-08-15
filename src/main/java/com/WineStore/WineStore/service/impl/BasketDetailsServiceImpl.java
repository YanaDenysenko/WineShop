package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.ProductDto;
import com.WineStore.WineStore.mapper.ProductMapper;
import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.repository.BasketDetailsRepository;
import com.WineStore.WineStore.service.BasketDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Set;

@AllArgsConstructor
@Service
public class BasketDetailsServiceImpl implements BasketDetailsService {
    private final BasketDetailsRepository basketDetailsRepository;
    private final ProductMapper productMapper;

    @Override
    public Set<BasketDetails> getAllByProduct(ProductDto productDto) {
        return basketDetailsRepository.getAllByProduct(productMapper.mapToModel(productDto));
    }
}
