package com.WineStore.WineStore.service;

import com.WineStore.WineStore.exeption.OrderStatusNotFoundException;
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

    @InjectMocks
    OrderStatusServiceImpl orderStatusService;

    @Test
    public void createOrderStatus(){
    }

    @Test
    public void getOrderStatusByCorrectId(){
        long id = 1;
        String name = "statusName";

        when(orderStatusRepository.findById(id)).thenReturn(fillOrderStatus(id, name));
        Assert.assertEquals(id, orderStatusService.getById(id).getId());
        Assert.assertEquals(name, orderStatusService.getById(id).getName());
    }

    @Test(expected = OrderStatusNotFoundException.class)
    public void getOrderStatusByNonExistenceId(){
        orderStatusService.getById(1);
    }

    @Test
    public void getAllOrderStatuses(){
    }

    @Test
    public void getOrderByCorrectName(){
        long id = 1;
        String name = "statusName";

        when(orderStatusRepository.getOrderStatusByName(name)).thenReturn(fillOrderStatus(id, name));
        Assert.assertEquals(id, orderStatusService.getByName(name).getId());
        Assert.assertEquals(name, orderStatusService.getByName(name).getName());
    }

    @Test(expected = OrderStatusNotFoundException.class)
    public void getOrderStatusByNonExistenceName(){
        orderStatusService.getByName("");
    }

    private Optional<OrderStatus> fillOrderStatus(long id, String name){
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(id);
        orderStatus.setName(name);
        return Optional.of(orderStatus);
    }

    private List<OrderStatus> fillOrderStatusList(){
        List<OrderStatus> orderStatusList = new ArrayList<>();
        orderStatusList.add(fillOrderStatus(1, "name1").get());
        orderStatusList.add(fillOrderStatus(2, "name2").get());
        return orderStatusList;
    }
}
