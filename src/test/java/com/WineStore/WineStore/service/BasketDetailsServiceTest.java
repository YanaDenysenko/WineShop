package com.WineStore.WineStore.service;

import com.WineStore.WineStore.exeption.BasketDetailsNotFountException;
import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.repository.BasketDetailsRepository;
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
import java.util.stream.IntStream;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasketDetailsServiceTest {

    @Mock
    BasketDetailsRepository basketDetailsRepository;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    BasketDetailsServiceImpl basketDetailsService;

    @Test
    public void createBasketDetails(){
    }

    @Test
    public void getBasketDetailsByCorrectId(){
        long id = 1;
        int quantity = 2;

        when(basketDetailsRepository.findById(id)).thenReturn(fillBasketDetails(id, quantity));
        Assert.assertEquals(id, basketDetailsService.getById(id).getId());
        Assert.assertEquals(quantity, basketDetailsService.getById(id).getQuantity());
    }

    @Test(expected = BasketDetailsNotFountException.class)
    public void getBasketDetailsByNonExistenceId(){
        basketDetailsService.getById(1);
    }

    @Test
    public void getAllBasketDetails(){
        when(basketDetailsRepository.findAll()).thenReturn(fillBasketDetailsList());

        IntStream.range(0, basketDetailsService.getAll().size())
                .forEach(i -> {
                    Assert.assertEquals(fillBasketDetailsList().get(i).getId(),
                            basketDetailsService.getAll().get(i).getId());
                    Assert.assertEquals(fillBasketDetailsList().get(i).getQuantity(),
                            basketDetailsService.getAll().get(i).getQuantity());
                });
    }

    @Test
    public void getAllByCorrectProduct(){
        long productId = 1;

        when(basketDetailsRepository.getAllByProduct(fillProduct(productId).get()))
                .thenReturn(fillBasketDetailsList());
        when(productRepository.findById(productId)).thenReturn(fillProduct(productId));

        IntStream.range(0, basketDetailsService.getAll().size())
                .forEach(i -> {
                    Assert.assertEquals(fillBasketDetailsList().get(i).getId(),
                            basketDetailsService.getAllByProduct(
                                    fillProduct(productId).get().getId()).get(i).getId());
                    Assert.assertEquals(fillBasketDetailsList().get(i).getQuantity(),
                            basketDetailsService.getAllByProduct(
                                    fillProduct(productId).get().getId()).get(i).getQuantity());
                });
    }

    private Optional<Product> fillProduct(long id){
        Product product = new Product();
        product.setId(id);
        return Optional.of(product);
    }

    private List<BasketDetails> fillBasketDetailsList(){
        List<BasketDetails> basketDetailsList = new ArrayList<>();
        basketDetailsList.add(fillBasketDetails(1,10).get());
        basketDetailsList.add(fillBasketDetails(2,15).get());
        return basketDetailsList;
    }

    private Optional<BasketDetails> fillBasketDetails(long id, int quantity){
        BasketDetails basketDetails = new BasketDetails();
        basketDetails.setId(id);
        basketDetails.setQuantity(quantity);
        return Optional.of(basketDetails);
    }
}
