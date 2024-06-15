package com.sb.get.mapping.example.mapper;

import com.sb.get.mapping.example.model.CustomerModel;
import com.sb.get.mapping.example.response.CustomerResponse;

public class CustomerMapper {
    public static CustomerResponse modelToResponseMapper(CustomerModel customerModel) {
        return CustomerResponse.builder()
                .customerId(customerModel.getCustomerId())
                .customerName(customerModel.getCustomerName())
                .customerAge(customerModel.getCustomerAge())
                .customerMobileNumber(customerModel.getCustomerMobileNumber())
                .customerEmailAddress(customerModel.getCustomerEmailAddress())
                .customerAddress(customerModel.getCustomerAddress())
                .createdDate(customerModel.getCreatedDate())
                .build();
    }
}
