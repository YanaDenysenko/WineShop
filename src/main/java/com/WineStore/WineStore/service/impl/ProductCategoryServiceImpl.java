package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.ProductCategoryCreateDto;
import com.WineStore.WineStore.dto.ProductCategoryDto;
import com.WineStore.WineStore.dto.ProductCategoryUIDto;
import com.WineStore.WineStore.mapper.impl.ProductCategoryCreateMapper;
import com.WineStore.WineStore.mapper.impl.ProductCategoryMapper;
import com.WineStore.WineStore.mapper.impl.ProductCategoryUIMapper;
import com.WineStore.WineStore.model.ProductCategory;
import com.WineStore.WineStore.repository.ProductCategoryRepository;
import com.WineStore.WineStore.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;
    private final ProductCategoryCreateMapper productCategoryCreateMapper;
    private final ProductCategoryUIMapper productCategoryUIMapper;

    @Override
    public ProductCategory save(ProductCategoryDto productCategoryDto) {
        return productCategoryRepository.save(productCategoryMapper.mapToModel(productCategoryDto));
    }

    @Override
    public Optional<ProductCategory> findById(long id) {
        return productCategoryRepository.findById(id);
    }

    @Override
    public void delete(ProductCategoryDto productCategoryDto) {
        productCategoryRepository.delete(productCategoryMapper.mapToModel(productCategoryDto));
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategoryUIDto create(ProductCategoryCreateDto productCategoryCreateDto) {
        return productCategoryUIMapper.mapToDto(productCategoryRepository.save(
                productCategoryCreateMapper.mapToModel(productCategoryCreateDto)));
    }
}
