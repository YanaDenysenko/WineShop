package com.WineStore.WineStore.mapper.impl.requestMapper;

import com.WineStore.WineStore.dto.requestDto.CustomerRequestDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequestMapper implements Mapper<Customer, CustomerRequestDto> {

    @Override
    public CustomerRequestDto mapToDto(Customer customer) {
        return null;
    }

    @Override
    public Customer mapToModel(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();
        customer.setLogin(customerRequestDto.getLogin());
        customer.setPassword(customerRequestDto.getPassword());
        customer.setName(customerRequestDto.getName());
        customer.setDateOfBirth(customerRequestDto.getDateOfBirth());
        customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
        customer.setAddress(customerRequestDto.getAddress());
        return customer;
    }
}
