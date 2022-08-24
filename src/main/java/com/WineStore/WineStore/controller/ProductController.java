package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.ProductCreateDto;
import com.WineStore.WineStore.dto.ProductUIDto;
import com.WineStore.WineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    ProductUIDto create (ProductCreateDto productCreateDto){
        return productService.create(productCreateDto);
    }
}
