package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.CustomerUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerUIMapper implements Mapper<Customer, CustomerUIDto> {

    @Override
    public CustomerUIDto mapToDto(Customer customer) {
        return CustomerUIDto.builder()
                .id(customer.getId())
                .login(customer.getLogin())
                .name(customer.getName())
                .dateOfBirth(customer.getDateOfBirth())
                .phoneNumber(customer.getPhoneNumber())
                .address(customer.getAddress())
                .build();
    }

    @Override
    public Customer mapToModel(CustomerUIDto customerUIDto) {
        return null;
    }
}
