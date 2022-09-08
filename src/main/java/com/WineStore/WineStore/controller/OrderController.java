package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.OrderRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderUIDto;
import com.WineStore.WineStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    OrderUIDto create(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.create(orderRequestDto);
    }

    @PutMapping("/updateById/{orderStatusId}")
    OrderUIDto updateById(@RequestBody OrderRequestDto orderRequestDto,
                           @PathVariable String orderStatusId) {
        return orderService.updateById(orderRequestDto, Long.parseLong(orderStatusId));
    }

    @DeleteMapping("/delete/{orderId}")
    void delete(@PathVariable String orderId) {
        orderService.deleteById(Long.parseLong(orderId));
    }

    @GetMapping("/getById/{orderId}")
    OrderUIDto getById(@PathVariable String orderId) {
        return orderService.getById(Long.parseLong(orderId));
    }

    @GetMapping("/getAll")
    List<OrderUIDto> getAllOrder() {
        return orderService.getAll();
    }

    @GetMapping("/getByCustomer/{customerId}")
    List<OrderUIDto> getByCustomer(@PathVariable String customerId) {
        return orderService.getOrderByCustomer(Long.parseLong(customerId));
    }
}
