package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.CustomerRequestDto;
import com.WineStore.WineStore.dto.uiDto.CustomerUIDto;
import com.WineStore.WineStore.exeption.CustomerNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.CustomerRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.CustomerUIMapper;
import com.WineStore.WineStore.model.Customer;
import com.WineStore.WineStore.repository.CustomerRepository;
import com.WineStore.WineStore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerRequestMapper customerRequestMapper;
    private final CustomerUIMapper customerUIMapper;

    @Override
    public CustomerUIDto create(CustomerRequestDto customerRequestDto) {
        return customerUIMapper.mapToDto(customerRepository.save(
                customerRequestMapper.mapToModel(customerRequestDto)));
    }

    @Override
    public Customer getById(long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
