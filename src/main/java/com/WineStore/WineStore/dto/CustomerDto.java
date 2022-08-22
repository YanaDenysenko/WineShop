package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@Builder
public class CustomerDto {
    private String login;

    private String password;

    private String name;

    private Timestamp dateOfBirth;

    private String phone_number;

    private String address;
}
