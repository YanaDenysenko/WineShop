package com.WineStore.WineStore.repository;

import com.WineStore.WineStore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select * from wine_store.order " +
            "where basket_id in (select id from wine_store.basket " +
            "where customer_id = :customer_id)",
            nativeQuery = true)
    List<Order> getOrderByCustomer (@Param("customer_id") long customer_id);
}
