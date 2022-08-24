package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.BasketDetailsCreateDto;
import com.WineStore.WineStore.dto.BasketDetailsUIDto;
import com.WineStore.WineStore.service.BasketDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/basket_details")
public class BasketDetailsController {
    private final BasketDetailsService basketDetailsService;

    @PostMapping("/create")
    BasketDetailsUIDto create (BasketDetailsCreateDto basketDetailsCreateDto){
        return basketDetailsService.create(basketDetailsCreateDto);
    }
}
