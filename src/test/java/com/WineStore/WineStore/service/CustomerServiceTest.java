package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.CustomerRequestDto;
import com.WineStore.WineStore.dto.uiDto.CustomerUIDto;
import com.WineStore.WineStore.exeption.CustomerNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.CustomerRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.CustomerUIMapper;
import com.WineStore.WineStore.model.Customer;
import com.WineStore.WineStore.repository.CustomerRepository;
import com.WineStore.WineStore.service.impl.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    CustomerUIMapper customerUIMapper;

    @Mock
    CustomerRequestMapper customerRequestMapper;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    public void createCustomer() {
        long id = 1;
        Customer mockCustomer = new Customer();
        CustomerUIDto mockCustomerUIDto = fillCustomerUIDto(id);
        CustomerRequestDto mockCustomerRequestDto = fillCustomerRequestDt();

        when(customerRepository.save(mockCustomer)).thenReturn(mockCustomer);
        when(customerUIMapper.mapToDto(mockCustomer)).thenReturn(mockCustomerUIDto);
        when(customerRequestMapper.mapToModel(mockCustomerRequestDto)).thenReturn(mockCustomer);

        Assert.assertEquals(mockCustomerUIDto, customerService.create(mockCustomerRequestDto));
    }

    @Test
    public void updateCustomerById() {
        long id = 1;
        Customer mockCustomer = new Customer();
        CustomerUIDto mockCustomerUIDto = fillCustomerUIDto(id);
        CustomerRequestDto mockCustomerRequestDto = fillCustomerRequestDt();

        when(customerRepository.save(mockCustomer)).thenReturn(mockCustomer);
        when(customerRepository.findById(id)).thenReturn(Optional.of(mockCustomer));
        when(customerUIMapper.mapToDto(mockCustomer)).thenReturn(mockCustomerUIDto);

        Assert.assertEquals(mockCustomerUIDto, customerService.updateById(
                mockCustomerRequestDto, id));
    }

    @Test
    public void deleteCustomerById() {
        long id = 1;
        Customer mockCustomer = new Customer();
        CustomerUIDto mockCustomerUIDto = fillCustomerUIDto(id);

        when(customerRepository.save(mockCustomer)).thenReturn(mockCustomer);
        when(customerRepository.findById(id)).thenReturn(Optional.of(mockCustomer));
        when(customerUIMapper.mapToDto(mockCustomer)).thenReturn(mockCustomerUIDto);

        Assert.assertEquals(mockCustomerUIDto, customerService.deleteById(id));
    }

    @Test
    public void getCustomerByCorrectId() {
        long id = 1;
        Customer mockCustomer = new Customer();
        CustomerUIDto mockCustomerUIDto = fillCustomerUIDto(id);

        when(customerRepository.findById(id)).thenReturn(Optional.of(mockCustomer));
        when(customerUIMapper.mapToDto(mockCustomer)).thenReturn(mockCustomerUIDto);

        Assert.assertEquals(mockCustomerUIDto, customerService.getById(id));
    }

    @Test(expected = CustomerNotFoundException.class)
    public void getCustomerByNonExistenceId() {
        customerService.getById(1);
    }

    //TODO
    @Test
    public void getAllCustomers() {
    }

    private CustomerUIDto fillCustomerUIDto(long id) {
        String login = "login";
        String password = "password";
        String name = "name";
        String phoneNumber = "phoneNumber";
        String address = "address";

        return CustomerUIDto.builder()
                .id(id)
                .login(login)
                .password(password)
                .name(name)
                .phoneNumber(phoneNumber)
                .address(address)
                .build();
    }

    private CustomerRequestDto fillCustomerRequestDt() {
        String login = "login";
        String password = "password";
        String name = "name";
        String phoneNumber = "phoneNumber";
        String address = "address";

        return CustomerRequestDto.builder()
                .login(login)
                .password(password)
                .name(name)
                .phoneNumber(phoneNumber)
                .address(address)
                .build();
    }

    List<CustomerUIDto> fillCustomerUIDtoList() {
        List<CustomerUIDto> customerUIDtoList = new ArrayList<>();
        customerUIDtoList.add(fillCustomerUIDto(1));
        customerUIDtoList.add(fillCustomerUIDto(2));
        return customerUIDtoList;
    }
}
