package com.ekart.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String emailId;

    private String name;

    private String password;

    private String phoneNumber;

    private String address;
}
