package com.WineStore.WineStore.mapper.impl.uiMapper;

import com.WineStore.WineStore.dto.uiDto.CustomerUIDto;
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
                .password(customer.getPassword())
                .name(customer.getName())
                .dateOfBirth(customer.getDateOfBirth())
                .phoneNumber(customer.getPhoneNumber())
                .address(customer.getAddress())
                .build();
    }

    @Override
    public Customer mapToModel(CustomerUIDto customerUIDto) {
        Customer customer = new Customer();
        customer.setId(customerUIDto.getId());
        customer.setLogin(customerUIDto.getLogin());
        customer.setPassword(customerUIDto.getPassword());
        customer.setName(customerUIDto.getName());
        customer.setDateOfBirth(customerUIDto.getDateOfBirth());
        customer.setPhoneNumber(customerUIDto.getPhoneNumber());
        customer.setAddress(customerUIDto.getAddress());
        return customer;
    }
}
