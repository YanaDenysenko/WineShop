package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.CustomerRequestDto;
import com.WineStore.WineStore.dto.uiDto.CustomerUIDto;
import java.util.List;

public interface CustomerService {

    CustomerUIDto create(CustomerRequestDto customerRequestDto);

    CustomerUIDto updateById(CustomerRequestDto customerRequestDto, long id);

    CustomerUIDto deleteById(long id);

    CustomerUIDto getById(long id);

    List<CustomerUIDto> getAll();
}
