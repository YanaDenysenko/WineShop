package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.CustomerRequestDto;
import com.WineStore.WineStore.dto.uiDto.CustomerUIDto;
import com.WineStore.WineStore.model.Customer;
import java.util.List;

public interface CustomerService {

    CustomerUIDto create(CustomerRequestDto customerRequestDto);

    Customer getById(long id);

    List<Customer> getAll();
}
