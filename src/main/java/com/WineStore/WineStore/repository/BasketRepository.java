package com.WineStore.WineStore.repository;

import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Query(value = "select * from wine_store.basket where customer_id = :cusromer_id and status = \"active\"", nativeQuery = true)
    Basket getCurrentBasketByCustomer(Customer customer);
}
