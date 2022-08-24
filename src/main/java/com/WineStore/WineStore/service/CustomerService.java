package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.CustomerCreateDto;
import com.WineStore.WineStore.dto.CustomerUIDto;
import com.WineStore.WineStore.model.Customer;

public interface CustomerService {
    CustomerUIDto create(CustomerCreateDto customerCreateDto);

    Customer getCustomerById(long id);
}
