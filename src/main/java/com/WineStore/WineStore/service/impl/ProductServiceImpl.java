package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.ProductCategoryDto;
import com.WineStore.WineStore.mapper.ProductCategoryMapper;
import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.repository.ProductRepository;
import com.WineStore.WineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Set;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryMapper productCategoryMapper;

    @Override
    public Set<Product> getProductById(long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Set<Product> getProductByCategory(ProductCategoryDto categoryDto) {
        return productRepository.getProductByCategory(productCategoryMapper.mapToModel(categoryDto));
    }

    @Override
    public Set<Product> getProductByManufacturer(String manufacturer) {
        return productRepository.getProductByManufacturer(manufacturer);
    }
}
