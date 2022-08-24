package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.BasketRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketUIDto;
import com.WineStore.WineStore.mapper.impl.uiMapper.BasketUIMapper;
import com.WineStore.WineStore.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/basket")
public class BasketController {
    private final BasketService basketService;
    private final BasketUIMapper basketUIMapper;

    @PostMapping("/create")
    BasketUIDto create (@RequestBody BasketRequestDto basketRequestDto){
        return basketService.create(basketRequestDto);
    }

    @GetMapping("/getById/{basketId}")
    BasketUIDto getBasketById(@PathVariable String basketId){
        return basketUIMapper.mapToDto(basketService.getById(Long.parseLong(basketId)));
    }

    @GetMapping("/getAll")
    List<BasketUIDto> getAllBasket(){
        return basketService.getAll().stream()
                .map(basketUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{basketId}")
    void delete (@PathVariable String basketId){
        basketService.deleteById(Long.parseLong(basketId));
    }

    @PutMapping("/update/{basketId}")
    BasketUIDto update (@RequestBody BasketRequestDto basketRequestDto,
                        @PathVariable String basketId){
        return basketService.updateById(basketRequestDto, Long.parseLong(basketId));
    }

    @GetMapping("/getCurrentBasket/{customerId}")
    BasketUIDto getCurrentBasket(@PathVariable String customerId){
        return basketUIMapper.mapToDto(basketService.getCurrentBasketByCustomer(
                Long.parseLong(customerId)));
    }
}
