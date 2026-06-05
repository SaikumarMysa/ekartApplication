package com.ekart.service;

import com.ekart.dto.CustomerDTO;
import com.ekart.entity.Customer;
import com.ekart.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer addCustomer(CustomerDTO customerDTO){

        //1. Creating a new Customer object
        Customer customer = new Customer();

        //2. set the details from dto object to customer object
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setEmailId(customerDTO.getEmailId());
        customer.setName(customerDTO.getName());
        customer.setPassword(customerDTO.getPassword());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setAddress(customerDTO.getAddress());

        //3. save the customer object
        customerRepository.save(customer);

        return customer;



    }
}
