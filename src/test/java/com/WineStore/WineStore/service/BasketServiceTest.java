package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.BasketRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketUIDto;
import com.WineStore.WineStore.dto.uiDto.CustomerUIDto;
import com.WineStore.WineStore.exeption.BasketNotFoundException;
import com.WineStore.WineStore.exeption.CurrentBasketNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.BasketRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.BasketUIMapper;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.model.Customer;
import com.WineStore.WineStore.repository.BasketRepository;
import com.WineStore.WineStore.repository.CustomerRepository;
import com.WineStore.WineStore.service.impl.BasketServiceImpl;
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
public class BasketServiceTest {

    @Mock
    private BasketRepository basketRepository;

    @InjectMocks
    private BasketServiceImpl basketService;

    @Mock
    private BasketUIMapper basketUIMapper;

    @Mock
    private BasketRequestMapper basketRequestMapper;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void createBasket() {
        long id = 1;
        Basket mockBasket = new Basket();
        BasketUIDto mockBasketUIDto = fillBasketUIDto(id);
        BasketRequestDto mockBasketRequestDto = fillBasketRequestDto();

        when(basketRepository.save(mockBasket)).thenReturn(mockBasket);
        when(basketUIMapper.mapToDto(mockBasket)).thenReturn(mockBasketUIDto);
        when(basketRequestMapper.mapToModel(mockBasketRequestDto)).thenReturn(mockBasket);

        Assert.assertEquals(mockBasketUIDto, basketService.create(mockBasketRequestDto));
    }

    @Test
    public void updateBasketById() {
        long id = 1;
        Basket mockBasket = new Basket();
        BasketUIDto mockBasketUIDto = fillBasketUIDto(id);
        BasketRequestDto mockBasketRequestDto = fillBasketRequestDto();

        when(basketRepository.save(mockBasket)).thenReturn(mockBasket);
        when(basketRepository.findById(id)).thenReturn(Optional.of(mockBasket));
        when(basketUIMapper.mapToDto(mockBasket)).thenReturn(mockBasketUIDto);
        when(customerRepository.findById(mockBasketRequestDto.getCustomerId()))
                .thenReturn(Optional.of(new Customer()));

        Assert.assertEquals(mockBasketUIDto, basketService.updateById(mockBasketRequestDto, id));
    }

    @Test
    public void getBasketByCorrectId() {
        long id = 1;
        Basket mockBasket = new Basket();
        BasketUIDto mockBasketUIDto = fillBasketUIDto(id);

        when(basketUIMapper.mapToDto(mockBasket)).thenReturn(mockBasketUIDto);
        when(basketRepository.findById(id)).thenReturn(Optional.of(mockBasket));

        Assert.assertEquals(mockBasketUIDto, basketService.getById(id));
    }

    @Test
    public void getCurrentBasketByCustomer() {
        long id = 1;
        Basket mockBasket = new Basket();
        BasketUIDto mockBasketUIDto = fillBasketUIDto(id);

        when(basketUIMapper.mapToDto(mockBasket)).thenReturn(mockBasketUIDto);
        when(basketRepository.getCurrentBasketByCustomer(1))
                .thenReturn(Optional.of(mockBasket));

        Assert.assertEquals(mockBasketUIDto, basketService.getCurrentBasketByCustomer(1));
    }

    //TODO
    @Test
    public void getAllBaskets() {

    }

    @Test(expected = BasketNotFoundException.class)
    public void getBasketByNonExistentId() {
        basketService.getById(2);
    }

    @Test(expected = CurrentBasketNotFoundException.class)
    public void getNonExistentCurrentBasket() {
        basketService.getCurrentBasketByCustomer(1);
    }

    private BasketUIDto fillBasketUIDto(long id) {
        return BasketUIDto.builder()
                .id(id)
                .customerUIDto(CustomerUIDto.builder().id(1).build())
                .build();
    }

    private BasketRequestDto fillBasketRequestDto() {
        return BasketRequestDto.builder()
                .customerId(1)
                .build();
    }

    private List<BasketUIDto> fillBasketUIDtoList() {
        List<BasketUIDto> basketUIDtoList = new ArrayList<>();
        basketUIDtoList.add(fillBasketUIDto(1));
        basketUIDtoList.add(fillBasketUIDto(2));
        return basketUIDtoList;
    }
}                                                                                                                                                       
                                                                                                                                                        