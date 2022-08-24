package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.CustomerCreateDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreateMapper implements Mapper<Customer, CustomerCreateDto> {

    @Override
    public CustomerCreateDto mapToDto(Customer customer) {
        return null;
    }

    @Override
    public Customer mapToModel(CustomerCreateDto customerCreateDto) {
        return null;
    }
}
