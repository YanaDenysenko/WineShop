package com.WineStore.WineStore.service;

import com.WineStore.WineStore.exeption.CustomerNotFoundException;
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
import java.util.stream.IntStream;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    public void createCustomer(){
    }

    @Test
    public void getCustomerByCorrectId(){
        long id = 1;
        String login = "login";
        String password = "password";
        String name = "name";
        String phoneNumber = "phoneNumber";
        String address = "address";

        when(customerRepository.findById(id)).thenReturn(fillCustomer(
                id, login, password, name, phoneNumber, address));

        Assert.assertEquals(id, customerService.getById(id).getId());
        Assert.assertEquals(login, customerService.getById(id).getLogin());
        Assert.assertEquals(password, customerService.getById(id).getPassword());
        Assert.assertEquals(phoneNumber, customerService.getById(id).getPhoneNumber());
        Assert.assertEquals(address, customerService.getById(id).getAddress());
    }

    @Test(expected = CustomerNotFoundException.class)
    public void getCustomerByNonExistenceId(){
        customerService.getById(1);
    }

    @Test
    public void getAllCustomers(){
        when(customerRepository.findAll()).thenReturn(fillCustomerList());

        IntStream.range(0, customerService.getAll().size())
                .forEach(i -> {
                    Assert.assertEquals(fillCustomerList().get(i).getId(),
                            customerService.getAll().get(i).getId());
                    Assert.assertEquals(fillCustomerList().get(i).getLogin(),
                            customerService.getAll().get(i).getLogin());
                    Assert.assertEquals(fillCustomerList().get(i).getPassword(),
                            customerService.getAll().get(i).getPassword());
                    Assert.assertEquals(fillCustomerList().get(i).getPhoneNumber(),
                            customerService.getAll().get(i).getPhoneNumber());
                    Assert.assertEquals(fillCustomerList().get(i).getAddress(),
                            customerService.getAll().get(i).getAddress());
                });
    }

    private List<Customer> fillCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(fillCustomer(1, "login1", "password1", "name1",
                "phoneNumber1", "address1").get());
        customerList.add(fillCustomer(2, "login2", "password2", "name2",
                "phoneNumber2", "address2").get());
        return customerList;
    }

    private Optional<Customer> fillCustomer(long id, String login, String password, String name,
                                            String phoneNumber, String address) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setLogin(login);
        customer.setPassword(password);
        customer.setName(name);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        return Optional.of(customer);
    }
}
