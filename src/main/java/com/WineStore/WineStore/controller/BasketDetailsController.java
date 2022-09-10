package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.BasketDetailsRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketDetailsUIDto;
import com.WineStore.WineStore.service.BasketDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/basketDetails")
public class BasketDetailsController {
    private final BasketDetailsService basketDetailsService;

    @PostMapping("/create")
    BasketDetailsUIDto create(@RequestBody BasketDetailsRequestDto basketDetailsRequestDto) {
        return basketDetailsService.create(basketDetailsRequestDto);
    }

    @PutMapping("/updateById/{basketDetailsId}")
    BasketDetailsUIDto update(@RequestBody BasketDetailsRequestDto basketDetailsRequestDto,
                               @PathVariable String basketDetailsId) {
        return basketDetailsService.updateById(basketDetailsRequestDto,
                Long.parseLong(basketDetailsId));
    }

    @DeleteMapping("/deleteById/{basketDetailsId}")
    void deleteById(@PathVariable String basketDetailsId) {
        basketDetailsService.deleteById(Long.parseLong(basketDetailsId));
    }

    @GetMapping("/getById/{basketDetailsId}")
    BasketDetailsUIDto getById(@PathVariable String basketDetailsId) {
        return basketDetailsService.getById(Long.parseLong(basketDetailsId));
    }

    @GetMapping("/getAll")
    List<BasketDetailsUIDto> getAllBasketDetails() {
        return basketDetailsService.getAll();
    }

    @GetMapping("/getAllByProduct/{productId}")
    List<BasketDetailsUIDto> getAllByProduct(@PathVariable String productId) {
        return basketDetailsService.getAllByProduct(Long.parseLong(productId));
    }
}
