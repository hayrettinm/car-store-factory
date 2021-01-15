package com.hayrettinm.carstorefactory.web.controller;


import com.hayrettinm.carstorefactory.service.CustomerService;

import com.hayrettinm.carstorefactory.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCar(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("customerId") UUID customerId, @Valid @RequestBody CustomerDto customerDto){

        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId")UUID customerId){
        customerService.deleteById(customerId);

    }
}
