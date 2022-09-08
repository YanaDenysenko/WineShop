package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.BasketDetailsRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketDetailsUIDto;
import com.WineStore.WineStore.dto.uiDto.BasketUIDto;
import com.WineStore.WineStore.dto.uiDto.ProductUIDto;
import com.WineStore.WineStore.exeption.BasketDetailsNotFountException;
import com.WineStore.WineStore.mapper.impl.requestMapper.BasketDetailsRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.BasketDetailsUIMapper;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.repository.BasketDetailsRepository;
import com.WineStore.WineStore.repository.BasketRepository;
import com.WineStore.WineStore.repository.ProductRepository;
import com.WineStore.WineStore.service.impl.BasketDetailsServiceImpl;
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
public class BasketDetailsServiceTest {

    @Mock
    BasketDetailsRepository basketDetailsRepository;

    @Mock
    ProductRepository productRepository;

    @Mock
    BasketRepository basketRepository;

    @Mock
    BasketDetailsRequestMapper basketDetailsRequestMapper;

    @Mock
    BasketDetailsUIMapper basketDetailsUIMapper;

    @InjectMocks
    BasketDetailsServiceImpl basketDetailsService;

    @Test
    public void createBasketDetails() {
        long id = 1;
        BasketDetails mockBasketDetails = new BasketDetails();
        BasketDetailsUIDto mockBasketDetailsUIDto = fillBasketDetailsUIDto(id);
        BasketDetailsRequestDto mockBasketDetailsRequestDto = fillBasketDetailsRequestDto();

        when(basketDetailsUIMapper.mapToDto(mockBasketDetails)).thenReturn(mockBasketDetailsUIDto);
        when(basketDetailsRepository.save(mockBasketDetails)).thenReturn(mockBasketDetails);
        when(basketDetailsRequestMapper.mapToModel(mockBasketDetailsRequestDto))
                .thenReturn(mockBasketDetails);

        Assert.assertEquals(mockBasketDetailsUIDto, basketDetailsService.create(
                mockBasketDetailsRequestDto));
    }

    @Test
    public void updateBasketDetailsById() {
        long id = 1;
        BasketDetails mockBasketDetails = new BasketDetails();
        BasketDetailsUIDto mockBasketDetailsUIDto = fillBasketDetailsUIDto(id);
        BasketDetailsRequestDto mockBasketDetailsRequestDto = fillBasketDetailsRequestDto();

        when(basketDetailsUIMapper.mapToDto(mockBasketDetails)).thenReturn(mockBasketDetailsUIDto);
        when(basketDetailsRepository.save(mockBasketDetails)).thenReturn(mockBasketDetails);
        when(basketDetailsRepository.findById(id)).thenReturn(Optional.of(mockBasketDetails));
        when(productRepository.findById(mockBasketDetailsRequestDto.getProductId()))
                .thenReturn(Optional.of(new Product()));
        when(basketRepository.findById(mockBasketDetailsRequestDto.getBasketId()))
                .thenReturn(Optional.of(new Basket()));

        Assert.assertEquals(mockBasketDetailsUIDto, basketDetailsService.updateById(
                mockBasketDetailsRequestDto, id));
    }

    @Test
    public void getBasketDetailsByCorrectId() {
        long id = 1;
        BasketDetails mockBasketDetails = new BasketDetails();
        BasketDetailsUIDto mockBasketDetailsUIDto = fillBasketDetailsUIDto(id);


        when(basketDetailsUIMapper.mapToDto(mockBasketDetails)).thenReturn(mockBasketDetailsUIDto);
        when(basketDetailsRepository.findById(id)).thenReturn(Optional.of(mockBasketDetails));

        Assert.assertEquals(mockBasketDetailsUIDto, basketDetailsService.getById(id));
    }

    @Test(expected = BasketDetailsNotFountException.class)
    public void getBasketDetailsByNonExistenceId() {
        basketDetailsService.getById(1);
    }

    //TODO
    @Test
    public void getAllBasketDetails() {

    }

    //TODO
    @Test
    public void getAllByCorrectProduct() {

    }

    private List<BasketDetailsUIDto> fillBasketDetailsUIDtoList() {
        List<BasketDetailsUIDto> basketDetailsUIDtoList = new ArrayList<>();
        basketDetailsUIDtoList.add(fillBasketDetailsUIDto(1));
        basketDetailsUIDtoList.add(fillBasketDetailsUIDto(2));
        return basketDetailsUIDtoList;
    }

    private BasketDetailsUIDto fillBasketDetailsUIDto(long id) {
        int quantity = 2;
        return BasketDetailsUIDto.builder()
                .id(id)
                .basketUIDto(BasketUIDto.builder().id(1).build())
                .productUIDto(ProductUIDto.builder().id(1).build())
                .quantity(quantity)
                .build();
    }

    private BasketDetailsRequestDto fillBasketDetailsRequestDto() {
        int quantity = 2;
        long productId = 1;
        long basketId = 1;
        return BasketDetailsRequestDto.builder()
                .productId(1)
                .basketId(1)
                .quantity(quantity)
                .build();
    }
}
