package com.WineStore.WineStore.dto.uiDto;

import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Builder
public class CustomerUIDto {
    private long id;
    private String login;
    private String name;
    private Timestamp dateOfBirth;
    private String phoneNumber;
    private String address;
}
