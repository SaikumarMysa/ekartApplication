package com.ekart.dto;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CustomerDTO {
    @Id
    private Integer customerId;
    private String emailId;
    private String name;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
    private String address;
}
