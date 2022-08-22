package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.BasketDto;
import com.WineStore.WineStore.service.BasketService;
import com.WineStore.WineStore.service.impl.BasketServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/basket")
public class BasketController {
    private final BasketService basketService;


}
