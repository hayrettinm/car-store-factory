package com.hayrettinm.carstorefactory.web.mapper;

import com.hayrettinm.carstorefactory.domain.Customer;
import com.hayrettinm.carstorefactory.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);
}
