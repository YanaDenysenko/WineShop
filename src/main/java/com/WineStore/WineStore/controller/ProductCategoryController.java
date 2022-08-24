package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.ProductCategoryCreateDto;
import com.WineStore.WineStore.dto.ProductCategoryUIDto;
import com.WineStore.WineStore.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product-category")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @PostMapping("/create")
    ProductCategoryUIDto create (ProductCategoryCreateDto productCategoryCreateDto){
        return productCategoryService.create(productCategoryCreateDto);
    }
}
