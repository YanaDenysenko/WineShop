package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Builder
public class CustomerDto {
    private String login;
    private String password;
    private String name;
    private Timestamp dateOfBirth;
    private String phoneNumber;
    private String address;
}
