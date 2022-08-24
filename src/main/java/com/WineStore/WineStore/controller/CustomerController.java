package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.CustomerRequestDto;
import com.WineStore.WineStore.dto.uiDto.CustomerUIDto;
import com.WineStore.WineStore.mapper.impl.uiMapper.CustomerUIMapper;
import com.WineStore.WineStore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerUIMapper customerUIMapper;

    @PostMapping("/create")
    CustomerUIDto create (@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.create(customerRequestDto);
    }

    @GetMapping("/getById/{customerId}")
    CustomerUIDto getById (@PathVariable String customerId){
        return customerUIMapper.mapToDto(
                customerService.getById(Long.parseLong(customerId)));
    }

    @GetMapping("/getAll")
    List<CustomerUIDto> getAllCustomer(){
        return customerService.getAll().stream()
                .map(customerUIMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
