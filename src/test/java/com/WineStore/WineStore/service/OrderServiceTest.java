package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.OrderRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketUIDto;
import com.WineStore.WineStore.dto.uiDto.OrderStatusUIDto;
import com.WineStore.WineStore.dto.uiDto.OrderUIDto;
import com.WineStore.WineStore.exeption.OrderNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.OrderRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.OrderUIMapper;
import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.model.Order;
import com.WineStore.WineStore.model.OrderStatus;
import com.WineStore.WineStore.repository.BasketRepository;
import com.WineStore.WineStore.repository.OrderRepository;
import com.WineStore.WineStore.repository.OrderStatusRepository;
import com.WineStore.WineStore.service.impl.OrderServiceImpl;
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
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    BasketRepository basketRepository;

    @Mock
    OrderStatusRepository orderStatusRepository;

    @Mock
    OrderUIMapper orderUIMapper;

    @Mock
    OrderRequestMapper orderRequestMapper;

    @InjectMocks
    OrderServiceImpl orderService;

    @Test
    public void createOrder() {
        long id = 1;
        Order mockOrder = new Order();
        OrderUIDto mockOrderUIDto = fillOrderUIDto(id);
        OrderRequestDto mockOrderRequestDto = fillOrderRequestDto();

        when(orderRepository.save(mockOrder)).thenReturn(mockOrder);
        when(orderUIMapper.mapToDto(mockOrder)).thenReturn(mockOrderUIDto);
        when(orderRequestMapper.mapToModel(mockOrderRequestDto)).thenReturn(mockOrder);

        Assert.assertEquals(mockOrderUIDto, orderService.create(mockOrderRequestDto));
    }

    @Test
    public void updateOrderById() {
        long id = 1;
        Order mockOrder = new Order();
        OrderUIDto mockOrderUIDto = fillOrderUIDto(id);
        OrderRequestDto mockOrderRequestDto = fillOrderRequestDto();

        when(orderRepository.save(mockOrder)).thenReturn(mockOrder);
        when(orderRepository.findById(id)).thenReturn(Optional.of(mockOrder));
        when(orderUIMapper.mapToDto(mockOrder)).thenReturn(mockOrderUIDto);
        when(basketRepository.findById(mockOrderRequestDto.getBasketId()))
                .thenReturn(Optional.of(new Basket()));
        when(orderStatusRepository.findById(mockOrderRequestDto.getOrderStatusId()))
                .thenReturn(Optional.of(new OrderStatus()));

        Assert.assertEquals(mockOrderUIDto, orderService.updateById(mockOrderRequestDto, id));
    }

    @Test
    public void getOrderByCorrectId() {
    }

    @Test(expected = OrderNotFoundException.class)
    public void getOrderByNonExistenceId() {
        orderService.getById(1);
    }

    @Test
    public void getAllOrders() {
    }

    @Test
    public void getOrdersByCustomerId() {
    }

    private OrderUIDto fillOrderUIDto(long id) {
        return OrderUIDto.builder()
                .id(id)
                .basketUIDto(BasketUIDto.builder().id(1).build())
                .orderStatusUIDto(OrderStatusUIDto.builder().id(1).build())
                .build();
    }

    private OrderRequestDto fillOrderRequestDto() {
        return OrderRequestDto.builder()
                .basketId(1)
                .orderStatusId(1)
                .build();
    }

    private List<OrderUIDto> fillOrderUIDtoList() {
        List<OrderUIDto> orderUIDtoList = new ArrayList<>();
        orderUIDtoList.add(fillOrderUIDto(1));
        orderUIDtoList.add(fillOrderUIDto(2));
        return orderUIDtoList;
    }
}
