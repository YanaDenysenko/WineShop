package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.CustomerUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Customer;

public class CustomerUIMapper implements Mapper<Customer, CustomerUIDto> {

    @Override
    public CustomerUIDto mapToDto(Customer customer) {
        return null;
    }

    @Override
    public Customer mapToModel(CustomerUIDto customerUIDto) {
        return null;
    }
}
