package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.CustomerCreateDto;
import com.WineStore.WineStore.dto.CustomerUIDto;
import com.WineStore.WineStore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    CustomerUIDto create (CustomerCreateDto customerCreateDto){
        return customerService.create(customerCreateDto);
    }
}
