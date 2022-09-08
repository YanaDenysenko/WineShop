package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.WineRequestDto;
import com.WineStore.WineStore.dto.uiDto.WineUIDto;
import com.WineStore.WineStore.service.WineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/wine")
public class WineController {
    private final WineService wineService;

    @PostMapping("/create")
    WineUIDto create(@RequestBody WineRequestDto wineRequestDto) {
        return wineService.create(wineRequestDto);
    }

    @PutMapping("/updateById/{wineId}")
    WineUIDto updateById(@RequestBody WineRequestDto wineRequestDto, @PathVariable String wineId) {
        return wineService.updateById(wineRequestDto, Long.parseLong(wineId));
    }

    @DeleteMapping("/deleteById/{wineId}")
    WineUIDto deleteById(@PathVariable String wineId) {
        return wineService.deleteById(Long.parseLong(wineId));
    }

    @GetMapping("/getById/{wineId}")
    WineUIDto getById(@PathVariable String wineId) {
        return wineService.getById(Long.parseLong(wineId));
    }

    @GetMapping("/getAll")
    List<WineUIDto> getAllWine() {
        return wineService.getAll();
    }
}
