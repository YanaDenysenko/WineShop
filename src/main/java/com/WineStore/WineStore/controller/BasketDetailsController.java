package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.BasketDetailsRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketDetailsUIDto;
import com.WineStore.WineStore.mapper.impl.uiMapper.BasketDetailsUIMapper;
import com.WineStore.WineStore.service.BasketDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/basketDetails")
public class BasketDetailsController {
    private final BasketDetailsService basketDetailsService;
    private final BasketDetailsUIMapper basketDetailsUIMapper;

    @PostMapping("/create")
    BasketDetailsUIDto create (@RequestBody BasketDetailsRequestDto basketDetailsRequestDto){
        return basketDetailsService.create(basketDetailsRequestDto);
    }

    @GetMapping("/getById/{basketDetailsId}")
    BasketDetailsUIDto getById (@PathVariable String basketDetailsId){
        return basketDetailsUIMapper.mapToDto(
                basketDetailsService.getById(Long.parseLong(basketDetailsId)));
    }

    @GetMapping("/getAll")
    List<BasketDetailsUIDto> getAllBasketDetails(){
        return basketDetailsService.getAll().stream()
                .map(basketDetailsUIMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
