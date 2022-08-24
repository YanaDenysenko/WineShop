package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.ProductRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductUIDto;
import com.WineStore.WineStore.mapper.impl.uiMapper.ProductUIMapper;
import com.WineStore.WineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;
    private final ProductUIMapper productUIMapper;

    @PostMapping("/create")
    ProductUIDto create (@RequestBody ProductRequestDto productRequestDto){
        return productService.create(productRequestDto);
    }

    @GetMapping("/getById/{productId}")
    ProductUIDto getById (@PathVariable String productId){
        return productUIMapper.mapToDto(productService.getById(Long.parseLong(productId)));
    }

    @GetMapping("/getAll")
    List<ProductUIDto> getAllProduct(){
        return productService.getAll().stream()
                .map(productUIMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
