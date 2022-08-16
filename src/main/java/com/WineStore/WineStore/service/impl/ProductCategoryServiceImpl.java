package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.model.ProductCategory;
import com.WineStore.WineStore.repository.ProductCategoryRepository;
import com.WineStore.WineStore.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    ProductCategoryRepository productCategoryRepository;



    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }
}
