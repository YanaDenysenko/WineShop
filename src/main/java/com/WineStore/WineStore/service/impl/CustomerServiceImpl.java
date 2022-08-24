package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.CustomerCreateDto;
import com.WineStore.WineStore.dto.CustomerUIDto;
import com.WineStore.WineStore.mapper.impl.CustomerCreateMapper;
import com.WineStore.WineStore.mapper.impl.CustomerUIMapper;
import com.WineStore.WineStore.model.Customer;
import com.WineStore.WineStore.repository.CustomerRepository;
import com.WineStore.WineStore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerCreateMapper customerCreateMapper;
    private final CustomerUIMapper customerUIMapper;

    @Override
    public CustomerUIDto create(CustomerCreateDto customerCreateDto) {
        return customerUIMapper.mapToDto(customerRepository.save(
                customerCreateMapper.mapToModel(customerCreateDto)));
    }

    //TODO
    @Override
    public Customer getCustomerById(long id) {
        return null;
    }
}
