package com.WineStore.WineStore.service;

import com.WineStore.WineStore.exeption.OrderNotFoundException;
import com.WineStore.WineStore.model.Order;
import com.WineStore.WineStore.repository.OrderRepository;
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
import java.util.stream.IntStream;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderServiceImpl orderService;

    @Test
    public void createOrder(){
    }

    @Test
    public void getOrderByCorrectId(){
        long id = 1;

        when(orderRepository.findById(id)).thenReturn(fillOrder(id));
        Assert.assertEquals(id, orderService.getById(id).getId());
    }

    @Test(expected = OrderNotFoundException.class)
    public void getOrderByNonExistenceId(){
        orderService.getById(1);
    }

    @Test
    public void getAllOrders(){
        when(orderRepository.findAll()).thenReturn(fillOrderList());
        IntStream.range(0, orderService.getAll().size())
                .forEach(i -> Assert.assertEquals(fillOrderList().get(i).getId(),
                        orderService.getAll().get(i).getId()));
    }

    @Test
    public void getOrdersByCustomerId(){
        long id = 1;
        when(orderRepository.getOrderByCustomer(id)).thenReturn(fillOrderList());
        IntStream.range(0, orderService.getOrderByCustomer(id).size())
                .forEach(i -> Assert.assertEquals(fillOrderList().get(i).getId(),
                        orderService.getOrderByCustomer(id).get(i).getId()));
    }

    private Optional<Order> fillOrder(long id) {
        Order order = new Order();
        order.setId(id);
        return Optional.of(order);
    }

    private List<Order> fillOrderList() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(fillOrder(1).get());
        orderList.add(fillOrder(2).get());
        return orderList;
    }
}
