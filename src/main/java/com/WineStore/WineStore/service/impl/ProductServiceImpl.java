package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.ProductCategoryDto;
import com.WineStore.WineStore.dto.ProductCreateDto;
import com.WineStore.WineStore.dto.ProductUIDto;
import com.WineStore.WineStore.mapper.impl.ProductCreateMapper;
import com.WineStore.WineStore.mapper.impl.ProductMapper;
import com.WineStore.WineStore.mapper.impl.ProductUIMapper;
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
    private final ProductMapper productMapper;
    private final ProductUIMapper productUIMapper;
    private final ProductCreateMapper productCreateMapper;

    @Override
    public Set<Product> getProductById(long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Set<Product> getProductByCategory(ProductCategoryDto categoryDto) {
        return null;
    }

    @Override
    public Set<Product> getProductByManufacturer(String manufacturer) {
        return productRepository.getProductByManufacturer(manufacturer);
    }

    @Override
    public ProductUIDto create(ProductCreateDto productCreateDto) {
        return productUIMapper.mapToDto(productRepository.save(
                productCreateMapper.mapToModel(productCreateDto)));
    }
}
