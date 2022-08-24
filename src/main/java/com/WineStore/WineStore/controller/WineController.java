package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.WineRequestDto;
import com.WineStore.WineStore.dto.uiDto.WineUIDto;
import com.WineStore.WineStore.mapper.impl.uiMapper.WineUIMapper;
import com.WineStore.WineStore.service.WineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/wine")
public class WineController {
    private final WineService wineService;
    private final WineUIMapper wineUIMapper;

    @PostMapping("/create")
    WineUIDto create (@RequestBody WineRequestDto wineRequestDto){
        return wineService.create(wineRequestDto);
    }

    @GetMapping("/getById/{wineId}")
    WineUIDto getById (@PathVariable String wineId){
        return wineUIMapper.mapToDto(wineService.getById(Long.parseLong(wineId)));
    }

    @GetMapping("/getAll")
    List<WineUIDto> getAllWine(){
        return wineService.getAll().stream()
                .map(wineUIMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
