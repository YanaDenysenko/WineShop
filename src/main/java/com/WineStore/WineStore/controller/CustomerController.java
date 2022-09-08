package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.CustomerRequestDto;
import com.WineStore.WineStore.dto.uiDto.CustomerUIDto;
import com.WineStore.WineStore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    CustomerUIDto create(@RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.create(customerRequestDto);
    }

    @PutMapping("/updateById/{customerId}")
    CustomerUIDto updateById(@RequestBody CustomerRequestDto customerRequestDto,
                              @PathVariable String customerId) {
        return customerService.updateById(customerRequestDto, Long.parseLong(customerId));
    }

    @DeleteMapping("/deleteById/{customerId}")
    CustomerUIDto deleteById(@PathVariable String customerId) {
        return customerService.deleteById(Long.parseLong(customerId));
    }

    @GetMapping("/getById/{customerId}")
    CustomerUIDto getById(@PathVariable String customerId) {
        return customerService.getById(Long.parseLong(customerId));
    }

    @GetMapping("/getAll")
    List<CustomerUIDto> getAllCustomer() {
        return customerService.getAll();
    }
}
