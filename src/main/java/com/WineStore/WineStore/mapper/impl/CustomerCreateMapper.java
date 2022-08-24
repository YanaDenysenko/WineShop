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
        Customer customer = new Customer();
        customer.setLogin(customerCreateDto.getLogin());
        customer.setPassword(customerCreateDto.getPassword());
        customer.setName(customerCreateDto.getName());
        customer.setDateOfBirth(customerCreateDto.getDateOfBirth());
        customer.setPhoneNumber(customerCreateDto.getPhoneNumber());
        customer.setAddress(customerCreateDto.getAddress());
        return customer;
    }
}
