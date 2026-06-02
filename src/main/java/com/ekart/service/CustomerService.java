package com.ekart.service;

import com.ekart.dto.CustomerDTO;
import com.ekart.entity.Customer;

public interface CustomerService {
    public Customer addCustomer(CustomerDTO customerDTO);
    //public void loginCustomer(String emailId, String password);
}
