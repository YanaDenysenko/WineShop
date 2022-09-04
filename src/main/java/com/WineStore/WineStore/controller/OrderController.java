package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.OrderRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderUIDto;
import com.WineStore.WineStore.mapper.impl.uiMapper.OrderUIMapper;
import com.WineStore.WineStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderUIMapper orderUIMapper;

    @PostMapping("/create")
    OrderUIDto create (@RequestBody OrderRequestDto orderRequestDto){
        return orderService.create(orderRequestDto);
    }

    @GetMapping("/getById/{orderId}")
    OrderUIDto getById (@PathVariable String orderId){
        return orderUIMapper.mapToDto(orderService.getById(Long.parseLong(orderId)));
    }

    @GetMapping("/getAll")
    List<OrderUIDto> getAllOrder(){
        return orderService.getAll().stream()
                .map(orderUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/getByCustomer/{customerId}")
    List<OrderUIDto> getByCustomer(@PathVariable String customerId){
        return orderService.getOrderByCustomer(Long.parseLong(customerId)).stream()
                .map(orderUIMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
