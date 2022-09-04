package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.BasketRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketUIDto;
import com.WineStore.WineStore.exeption.BasketNotFoundException;
import com.WineStore.WineStore.exeption.CurrentBasketNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.BasketRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.BasketUIMapper;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.repository.BasketRepository;
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
import java.util.stream.IntStream;
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

    @Test
    public void createCorrectBasket(){
//        when(basketRequestMapper.mapToModel(fillBasketRequestDto().get()))
//                .thenReturn(fillBasket().get());
//        when(basketUIMapper.mapToDto())
//        Assert.assertEquals(1, basketService.create(
//                fillBasketRequestDto().get()).getCustomerUIDto().getId());
    }

    @Test
    public void getBasketByCorrectId(){
        long basketId = 1;

        when(basketRepository.findById(basketId)).thenReturn(fillBasket(basketId));
        Assert.assertEquals(basketId, basketService.getById(basketId).getId());
    }

    @Test
    public void getCurrentBasketByCustomer(){
        long customerId = 1;
        long basketId = 1;

        when(basketRepository.getCurrentBasketByCustomer(customerId))
                .thenReturn(fillBasket(basketId));
        Assert.assertEquals(basketId,
                basketService.getCurrentBasketByCustomer(customerId).getId());
    }


    @Test
    public void getAllBaskets(){
        when(basketRepository.findAll()).thenReturn(fillBasketList());
        IntStream.range(0, basketService.getAll().size())
                .forEach(i -> Assert.assertEquals(
                        fillBasketList().get(i).getId(), basketService.getAll().get(i).getId()));
    }

    @Test(expected = BasketNotFoundException.class)
    public void getBasketByNonExistentId(){
        basketService.getById(2);
    }

    @Test(expected = CurrentBasketNotFoundException.class)
    public void getNonExistentCurrentBasket(){
        basketService.getCurrentBasketByCustomer(1);
    }

    private Optional<Basket> fillBasket(long id){
        Basket basket = new Basket();
        basket.setId(id);
        return Optional.of(basket);
    }

    private List<Basket> fillBasketList(){
        List<Basket> basketList = new ArrayList<>();
        basketList.add(fillBasket(1).get());
        basketList.add(fillBasket(2).get());
        basketList.add(fillBasket(3).get());
        return basketList;
    }

//    private Optional<BasketUIDto> fillBasketUIDto(){
//        return Optional.of(BasketUIDto.builder().id(1).build());
//    }
//
//    private Optional<BasketRequestDto> fillBasketRequestDto(){
//        return Optional.of(BasketRequestDto.builder().customerId(1).build());
//    }
}                                                                                                                                                       
                                                                                                                                                        