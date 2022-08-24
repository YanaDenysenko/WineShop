package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.BasketCreateDto;
import com.WineStore.WineStore.dto.BasketUIDto;
import com.WineStore.WineStore.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/basket")
public class BasketController {
    private final BasketService basketService;

    @PostMapping("/create")
    BasketUIDto create (BasketCreateDto basketCreateDto){
        return basketService.create(basketCreateDto);
    }
}
