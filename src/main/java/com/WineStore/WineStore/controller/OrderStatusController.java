package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.OrderStatusCreateDto;
import com.WineStore.WineStore.dto.OrderStatusUIDto;
import com.WineStore.WineStore.service.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/order_status")
public class OrderStatusController {
    private final OrderStatusService orderStatusService;

    @PostMapping("/create")
    OrderStatusUIDto create (OrderStatusCreateDto orderStatusCreateDto){
        return orderStatusService.create(orderStatusCreateDto);
    }
}
