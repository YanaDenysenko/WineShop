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
import java.util.List;

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
    public Product getById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getByManufacturer(String manufacturer) {
        return productRepository.getProductByManufacturer(manufacturer);
    }

    @Override
    public List<Product> getAvailableProduct() {
        return productRepository.getAvailableProduct();
    }

    @Override
    public List<Product> getProductByOrder(long orderId) {
        return productRepository.getProductByOrder(orderId);
    }

    @Override
    public List<Product> getProductByCategory(long categoryId) {
        return productRepository.getProductByCategory(
                productCategoryRepository.findById(categoryId).orElseThrow(
                        () -> new ProductCategoryNotFoundException(
                                String.valueOf(categoryId))));
    }
}
