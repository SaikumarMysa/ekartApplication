package com.ekart.api;

import com.ekart.dto.CustomerDTO;
import com.ekart.dto.LoginDTO;
import com.ekart.entity.Customer;
import com.ekart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-api")
public class CustomerAPI {
    //This API provides endpoints for customer regiester, and login.
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public String registerCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.signUp(customerDTO);
        return "Customer is created with id: "+customer.getCustomerId();
    }

    @PostMapping("/login")
    public String loginCustomer(@RequestBody LoginDTO loginDTO){
       Customer customer = customerService.authenticateCustomer(loginDTO.getEmailId(),loginDTO.getPassword());
       if(customer==null){
           return "email doesnot exists!!";
       }
        return "login successful for customerId: "+customer.getCustomerId();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer id){
        Customer customer = customerService.showCustomerDetails(id);

        CustomerDTO customerDTO =  new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setName(customer.getName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);

    }


}
