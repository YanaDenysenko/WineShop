package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.OrderStatusRequestDto;
import com.WineStore.WineStore.dto.uiDto.OrderStatusUIDto;
import com.WineStore.WineStore.exeption.OrderStatusNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.OrderStatusRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.OrderStatusUIMapper;
import com.WineStore.WineStore.model.OrderStatus;
import com.WineStore.WineStore.repository.OrderStatusRepository;
import com.WineStore.WineStore.service.impl.OrderStatusServiceImpl;
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
public class OrderStatusServiceTest {

    @Mock
    OrderStatusRepository orderStatusRepository;

    @Mock
    OrderStatusUIMapper orderStatusUIMapper;

    @Mock
    OrderStatusRequestMapper orderStatusRequestMapper;

    @InjectMocks
    OrderStatusServiceImpl orderStatusService;

    @Test
    public void createOrderStatus() {
        long id = 1;
        OrderStatus mockOrderStatus = new OrderStatus();
        OrderStatusUIDto mockOrderStatusUIDto = fillOrderStatusUIDto(id);
        OrderStatusRequestDto mockOrderStatusRequestDto = filOrderStatusRequestDto();

        when(orderStatusRepository.save(mockOrderStatus)).thenReturn(mockOrderStatus);
        when(orderStatusUIMapper.mapToDto(mockOrderStatus)).thenReturn(mockOrderStatusUIDto);
        when(orderStatusRequestMapper.mapToModel(mockOrderStatusRequestDto)).thenReturn(mockOrderStatus);

        Assert.assertEquals(mockOrderStatusUIDto, orderStatusService.create(mockOrderStatusRequestDto));
    }

    @Test
    public void updateOrderStatusById() {
        long id = 1;
        OrderStatus mockOrderStatus = new OrderStatus();
        OrderStatusUIDto mockOrderStatusUIDto = fillOrderStatusUIDto(id);
        OrderStatusRequestDto mockOrderStatusRequestDto = filOrderStatusRequestDto();

        when(orderStatusRepository.save(mockOrderStatus)).thenReturn(mockOrderStatus);
        when(orderStatusRepository.findById(id)).thenReturn(Optional.of(mockOrderStatus));
        when(orderStatusUIMapper.mapToDto(mockOrderStatus)).thenReturn(mockOrderStatusUIDto);

        Assert.assertEquals(mockOrderStatusUIDto, orderStatusService.updateById(
                mockOrderStatusRequestDto, id));
    }

    @Test
    public void deleteOrderStatusById() {
        long id = 1;
        OrderStatus mockOrderStatus = new OrderStatus();
        OrderStatusUIDto mockOrderStatusUIDto = fillOrderStatusUIDto(id);

        when(orderStatusRepository.save(mockOrderStatus)).thenReturn(mockOrderStatus);
        when(orderStatusRepository.findById(id)).thenReturn(Optional.of(mockOrderStatus));
        when(orderStatusUIMapper.mapToDto(mockOrderStatus)).thenReturn(mockOrderStatusUIDto);

        Assert.assertEquals(mockOrderStatusUIDto, orderStatusService.deleteById(id));
    }

    @Test
    public void getOrderStatusByCorrectId() {
        long id = 1;
        OrderStatus mockOrderStatus = new OrderStatus();
        OrderStatusUIDto mockOrderStatusUIDto = fillOrderStatusUIDto(id);

        when(orderStatusRepository.findById(id)).thenReturn(Optional.of(mockOrderStatus));
        when(orderStatusUIMapper.mapToDto(mockOrderStatus)).thenReturn(mockOrderStatusUIDto);

        Assert.assertEquals(mockOrderStatusUIDto, orderStatusService.getById(id));
    }

    @Test(expected = OrderStatusNotFoundException.class)
    public void getOrderStatusByNonExistenceId() {
        orderStatusService.getById(1);
    }

    //TODO
    @Test
    public void getAllOrderStatuses() {
    }

    @Test
    public void getOrderStatusByCorrectName() {
        long id = 1;
        String name = "name";
        OrderStatus mockOrderStatus = new OrderStatus();
        OrderStatusUIDto mockOrderStatusUIDto = fillOrderStatusUIDto(id);

        when(orderStatusRepository.getOrderStatusByName(name)).thenReturn(Optional.of(mockOrderStatus));
        when(orderStatusUIMapper.mapToDto(mockOrderStatus)).thenReturn(mockOrderStatusUIDto);

        Assert.assertEquals(mockOrderStatusUIDto, orderStatusService.getByName(name));
    }

    @Test(expected = OrderStatusNotFoundException.class)
    public void getOrderStatusByNonExistenceName() {
        orderStatusService.getByName("");
    }

    private OrderStatusUIDto fillOrderStatusUIDto(long id) {
        return OrderStatusUIDto.builder()
                .id(id)
                .name("name")
                .build();
    }

    private OrderStatusRequestDto filOrderStatusRequestDto() {
        return OrderStatusRequestDto.builder()
                .name("name")
                .build();
    }

    private List<OrderStatusUIDto> fillOrderStatusUIDtoList() {
        List<OrderStatusUIDto> orderStatusUIDtoList = new ArrayList<>();
        orderStatusUIDtoList.add(fillOrderStatusUIDto(1));
        orderStatusUIDtoList.add(fillOrderStatusUIDto(2));
        return orderStatusUIDtoList;
    }
}
