package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.ProductCategoryRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductCategoryUIDto;
import com.WineStore.WineStore.exeption.ProductCategoryNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.ProductCategoryRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.ProductCategoryUIMapper;
import com.WineStore.WineStore.model.ProductCategory;
import com.WineStore.WineStore.repository.ProductCategoryRepository;
import com.WineStore.WineStore.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryRequestMapper productCategoryRequestMapper;
    private final ProductCategoryUIMapper productCategoryUIMapper;

    @Override
    public ProductCategoryUIDto create(ProductCategoryRequestDto productCategoryRequestDto) {
        return productCategoryUIMapper.mapToDto(productCategoryRepository.save(
                productCategoryRequestMapper.mapToModel(productCategoryRequestDto)));
    }

    @Override
    public ProductCategory getById(long id) {
        return productCategoryRepository.findById(id)
                .orElseThrow(() -> new ProductCategoryNotFoundException(String.valueOf(id)));
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getByName(String name) {
        return productCategoryRepository.getByName(name)
                .orElseThrow(() -> new ProductCategoryNotFoundException(name));
    }
}
