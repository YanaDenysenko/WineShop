package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.CustomerCreateDto;
import com.WineStore.WineStore.dto.CustomerUIDto;

public interface CustomerService {
    CustomerUIDto create(CustomerCreateDto customerCreateDto);
}
