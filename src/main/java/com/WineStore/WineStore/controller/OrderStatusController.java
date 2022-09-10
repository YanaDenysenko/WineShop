package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.OrderStatusRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderStatusUIDto;
import com.WineStore.WineStore.service.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orderStatus")
public class OrderStatusController {
    private final OrderStatusService orderStatusService;

    @PostMapping("/create")
    OrderStatusUIDto create(@RequestBody OrderStatusRequestDto orderStatusRequestDto) {
        return orderStatusService.create(orderStatusRequestDto);
    }

    @PutMapping("/updateById/{orderStatusId}")
    OrderStatusUIDto updateById(@RequestBody OrderStatusRequestDto orderStatusRequestDto,
                                 @PathVariable String orderStatusId) {
        return orderStatusService.updateById(orderStatusRequestDto, Long.parseLong(orderStatusId));
    }

    @DeleteMapping("/deleteById/{orderStatusId}")
    OrderStatusUIDto deleteById(@PathVariable String orderStatusId) {
        return orderStatusService.deleteById(Long.parseLong(orderStatusId));
    }

    @GetMapping("/getById/{orderStatusId}")
    OrderStatusUIDto getById(@PathVariable String orderStatusId) {
        return orderStatusService.getById(Long.parseLong(orderStatusId));
    }

    @GetMapping("/getAll")
    List<OrderStatusUIDto> getAllOrderStatus() {
        return orderStatusService.getAll();
    }

    @GetMapping("/getByName/{orderStatusName}")
    OrderStatusUIDto getByName(@PathVariable String orderStatusName) {
        return orderStatusService.getByName(orderStatusName);
    }
}
