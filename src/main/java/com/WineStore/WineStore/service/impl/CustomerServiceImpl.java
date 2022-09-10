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
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

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
    public CustomerUIDto updateById(CustomerRequestDto customerRequestDto, long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customer.setLogin(customerRequestDto.getLogin());
        customer.setPassword(customerRequestDto.getPassword());
        customer.setName(customerRequestDto.getName());
        customer.setDateOfBirth(customerRequestDto.getDateOfBirth());
        customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
        customer.setAddress(customerRequestDto.getAddress());
        customer.setModified(new Timestamp(System.currentTimeMillis()));

        return customerUIMapper.mapToDto(customerRepository.save(customer));
    }

    @Override
    public CustomerUIDto deleteById(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customer.setModified(new Timestamp(System.currentTimeMillis()));
        customer.setDeleted(true);

        return customerUIMapper.mapToDto(customerRepository.save(customer));
    }

    @Override
    public CustomerUIDto getById(long id) {
        return customerUIMapper.mapToDto(customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id)));
    }

    @Override
    public List<CustomerUIDto> getAll() {
        return customerRepository.findAll().stream()
                .map(customerUIMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
