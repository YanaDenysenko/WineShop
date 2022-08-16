package com.WineStore.WineStore.repository;

import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Set<Product> getProductById(long id);
    Set<Product> getProductByCategory(ProductCategory category);
    Set<Product> getProductByManufacturer (String manufacturer);

    @Query(value = "select * from wine_store.product where quantity > 0", nativeQuery = true)
    Set<Product> getAvailableProduct ();

    @Query(value = "select * from wine_store.product " +
            "where id in (select product_id from basket_details " +
            "where basket_id in (select id from basket " +
            "where id in (select basket_id from order where id = :order_id)))", nativeQuery = true)
    ArrayList<Product> getProductByOrder(@Param("order_id") long order_id);


}
