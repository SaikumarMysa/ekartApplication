package com.ekart.api;

import com.ekart.dto.CustomerDTO;
import com.ekart.entity.Customer;
import com.ekart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerAPI {
    //This API provides endpoints for customer regiester, and login.
    @Autowired
    private CustomerService customerService;
    @PostMapping("/register")
    public String registerCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.addCustomer(customerDTO);
        return "Customr is created with id: "+customer.getCustomerId();

    }

    @PostMapping("/login")
    public void customerLogin(){

    }


}
