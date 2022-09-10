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
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

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
    public ProductCategoryUIDto updateById(ProductCategoryRequestDto productCategoryRequestDto,
                                           long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new ProductCategoryNotFoundException(String.valueOf(id)));

        productCategory.setName(productCategoryRequestDto.getName());
        productCategory.setModified(new Timestamp(System.currentTimeMillis()));

        return productCategoryUIMapper.mapToDto(productCategoryRepository.save(productCategory));
    }

    @Override
    public ProductCategoryUIDto deleteById(long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new ProductCategoryNotFoundException(String.valueOf(id)));

        productCategory.setDeleted(true);
        productCategory.setModified(new Timestamp(System.currentTimeMillis()));

        return productCategoryUIMapper.mapToDto(productCategoryRepository.save(productCategory));
    }

    @Override
    public ProductCategoryUIDto getById(long id) {
        return productCategoryUIMapper.mapToDto(productCategoryRepository.findById(id)
                .orElseThrow(() -> new ProductCategoryNotFoundException(String.valueOf(id))));
    }

    @Override
    public List<ProductCategoryUIDto> getAll() {
        return productCategoryRepository.findAll().stream()
                .map(productCategoryUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductCategoryUIDto getByName(String name) {
        return productCategoryUIMapper.mapToDto(productCategoryRepository.getByName(name)
                .orElseThrow(() -> new ProductCategoryNotFoundException(name)));
    }
}
