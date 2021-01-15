package com.hayrettinm.carstorefactory.service;

import com.hayrettinm.carstorefactory.web.model.CustomerDto;

import java.util.UUID;


public interface CustomerService {
    CustomerDto getCustomerById(UUID carId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteById(UUID carId);
}
