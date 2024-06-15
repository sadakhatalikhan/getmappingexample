package com.sb.get.mapping.example.service;

import com.sb.get.mapping.example.response.APIResponse;
import org.springframework.http.ResponseEntity;


public interface CustomerService {
    ResponseEntity<APIResponse> getAllCustomers();
    ResponseEntity<APIResponse> getByCustomerId(long customerId);
}
