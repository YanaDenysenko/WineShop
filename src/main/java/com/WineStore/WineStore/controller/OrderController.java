package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.OrderCreateDto;
import com.WineStore.WineStore.dto.OrderUIDto;
import com.WineStore.WineStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    OrderUIDto create (@RequestBody OrderCreateDto orderCreateDto){
        return orderService.create(orderCreateDto);
    }
}
