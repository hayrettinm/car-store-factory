package com.hayrettinm.carstorefactory.service;

import com.hayrettinm.carstorefactory.web.model.CarDto;
import com.hayrettinm.carstorefactory.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(customerId)
                .name("NewCustomer")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("new Customer")
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {

    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting car : {}", customerId );
    }
}
