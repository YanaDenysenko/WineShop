package com.WineStore.WineStore.repository;

import com.WineStore.WineStore.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    @Query(value = "select * from wine_store.basket " +
            "where customer_id = :cusromer_id " +
            "and id not in (select basket_id from wine_store.order)",
            nativeQuery = true)
    Basket getCurrentBasketByCustomer(@Param("customer_id") long customer_id);
}
