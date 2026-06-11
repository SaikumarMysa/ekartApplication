package com.ekart.service;

import com.ekart.dto.CustomerDTO;
import com.ekart.entity.Customer;
import com.ekart.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    //addCustomer- this method helps in registering a new customer
    public Customer signUp(CustomerDTO customerDTO){

        //1. Creating a new Customer object
        Customer customer = new Customer();

        //2. get the details from dto object and set it to customer object
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

//    public Customer loginCustomer(String emailId, String password){
//        if(emailId == null || password == null){
//            System.out.println("Enter valid emailId or password!!");
//        }
//
//        //1. Firstly, check whether the emailId is already present in db.
//        Optional<Customer> customerOpt  = customerRepository.findByEmailId(emailId);
//
//        if(customerOpt.isPresent()) {
//            Customer customer = customerOpt.get();
//
//            //2. check whether password is correct or not
//            if(customer.getPassword().equals(password)){
//                return customer;
//            }else{
//                System.out.println("Incorrect password!!");
//            }
//        }
//        return null;
//        }
//    }
public Customer authenticateCustomer(String emailId, String password){
    if(emailId == null || password == null){
        System.out.println("Enter valid emailId or password!!");
    }

    //1. Firstly, check whether the emailId is already present in db.
    Customer customer  = customerRepository.findByEmailId(emailId).orElseThrow(()->new RuntimeException("customer not found"));

    //2. check whether password is correct or not
        if(customer.getPassword().equals(password)){
            return customer;
        }else{
            System.out.println("Incorrect password!!");
        }
    return null;
}
    public Customer showCustomerDetails(Integer customerId){
        Customer customer = customerRepository.findById(customerId.toString()).orElse(new Customer());
        return customer;
    }
}

