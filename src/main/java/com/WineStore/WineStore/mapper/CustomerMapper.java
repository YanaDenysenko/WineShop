package com.WineStore.WineStore.mapper;

import com.WineStore.WineStore.dto.CustomerDto;
import com.WineStore.WineStore.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements Mapper<Customer, CustomerDto>{
    @Override
    public CustomerDto mapToDto(Customer customer) {
        return null;
    }

    @Override
    public Customer mapToModel(CustomerDto customerDto) {
        return null;
    }
}
