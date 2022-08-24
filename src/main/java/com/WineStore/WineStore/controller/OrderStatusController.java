package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.OrderStatusRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderStatusUIDto;
import com.WineStore.WineStore.mapper.impl.uiMapper.OrderStatusUIMapper;
import com.WineStore.WineStore.service.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orderStatus")
public class OrderStatusController {
    private final OrderStatusService orderStatusService;
    private final OrderStatusUIMapper orderStatusUIMapper;

    @PostMapping("/create")
    OrderStatusUIDto create (@RequestBody OrderStatusRequestDto orderStatusRequestDto){
        return orderStatusService.create(orderStatusRequestDto);
    }

    @GetMapping("/getById/{orderStatusId}")
    OrderStatusUIDto getById (@PathVariable String orderStatusId){
        return orderStatusUIMapper.mapToDto(
                orderStatusService.getById(Long.parseLong(orderStatusId)));
    }

    @GetMapping("/getAll")
    List<OrderStatusUIDto> getAllOrderStatus(){
        return orderStatusService.getAll().stream()
                .map(orderStatusUIMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
