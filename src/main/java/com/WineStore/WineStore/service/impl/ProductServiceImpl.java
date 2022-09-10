package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.ProductRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductUIDto;
import com.WineStore.WineStore.exeption.ProductCategoryNotFoundException;
import com.WineStore.WineStore.exeption.ProductNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.ProductRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.ProductUIMapper;
import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.repository.ProductCategoryRepository;
import com.WineStore.WineStore.repository.ProductRepository;
import com.WineStore.WineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductUIMapper productUIMapper;
    private final ProductRequestMapper productRequestMapper;
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductUIDto create(ProductRequestDto productRequestDto) {
        return productUIMapper.mapToDto(productRepository.save(
                productRequestMapper.mapToModel(productRequestDto)));
    }

    @Override
    public ProductUIDto updateById(ProductRequestDto productRequestDto, long id) {
        long productCategoryId = productRequestDto.getProductCategoryId();
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setVendorCode(productRequestDto.getVendorCode());
        product.setName(productRequestDto.getName());
        product.setCategory(productCategoryRepository.findById(productCategoryId)
                .orElseThrow(() -> new ProductCategoryNotFoundException(
                        String.valueOf(productCategoryId))));
        product.setUnitPrice(productRequestDto.getUnitPrice());
        product.setManufacturer(productRequestDto.getManufacturer());
        product.setQuantity(productRequestDto.getQuantity());
        product.setModified(new Timestamp(System.currentTimeMillis()));

        return productUIMapper.mapToDto(productRepository.save(product));
    }

    @Override
    public ProductUIDto deleteById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setDeleted(true);
        product.setModified(new Timestamp(System.currentTimeMillis()));

        return productUIMapper.mapToDto(productRepository.save(product));
    }

    @Override
    public ProductUIDto getById(long id) {
        return productUIMapper.mapToDto(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Override
    public List<ProductUIDto> getAll() {
        return productRepository.findAll().stream()
                .map(productUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductUIDto> getByManufacturer(String manufacturer) {
        return productRepository.getProductByManufacturer(manufacturer).stream()
                .map(productUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductUIDto> getAvailableProduct() {
        return productRepository.getAvailableProduct().stream()
                .map(productUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductUIDto> getProductByOrder(long orderId) {
        return productRepository.getProductByOrder(orderId).stream()
                .map(productUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductUIDto> getProductByCategory(long categoryId) {
        return productRepository.getProductByCategory(
                productCategoryRepository.findById(categoryId).orElseThrow(
                        () -> new ProductCategoryNotFoundException(
                                String.valueOf(categoryId)))).stream()
                .map(productUIMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
