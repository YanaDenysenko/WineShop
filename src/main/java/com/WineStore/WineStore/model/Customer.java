package com.WineStore.WineStore.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "customer", schema = "wine_store")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

//    @Column(name = "date_of_birth")
//    private Timestamp dateOfBirth;

    @Column(name = "phone_number", nullable = false)
    private String phone_number;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "create_at", nullable = false)
    private Timestamp createAt;

    @Column(name = "modified")
    private Timestamp modified;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Basket> baskets = new ArrayList<>();

}
