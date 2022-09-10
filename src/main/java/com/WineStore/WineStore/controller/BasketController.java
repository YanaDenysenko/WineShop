package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.BasketRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketUIDto;
import com.WineStore.WineStore.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/basket")
public class BasketController {
    private final BasketService basketService;

    @PostMapping("/create")
    BasketUIDto create(@RequestBody BasketRequestDto basketRequestDto) {
        return basketService.create(basketRequestDto);
    }

    @PutMapping("/updateById/{basketId}")
    BasketUIDto updateById(@RequestBody BasketRequestDto basketRequestDto,
                           @PathVariable String basketId) {
        return basketService.updateById(basketRequestDto, Long.parseLong(basketId));
    }

    @DeleteMapping("/deleteById/{basketId}")
    void deleteById(@PathVariable String basketId) {
        basketService.deleteById(Long.parseLong(basketId));
    }

    @GetMapping("/getById/{basketId}")
    BasketUIDto getBasketById(@PathVariable String basketId) {
        return basketService.getById(Long.parseLong(basketId));
    }

    @GetMapping("/getAll")
    List<BasketUIDto> getAllBasket() {
        return basketService.getAll();
    }

    @GetMapping("/getCurrentBasket/{customerId}")
    BasketUIDto getCurrentBasket(@PathVariable String customerId) {
        return basketService.getCurrentBasketByCustomer(Long.parseLong(customerId));
    }
}
