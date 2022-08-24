package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.WineCreateDto;
import com.WineStore.WineStore.dto.WineUIDto;
import com.WineStore.WineStore.service.WineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/wine")
public class WineController {
    private final WineService wineService;

    @PostMapping("/create")
    WineUIDto create (WineCreateDto wineCreateDto){
        return wineService.create(wineCreateDto);
    }
}
