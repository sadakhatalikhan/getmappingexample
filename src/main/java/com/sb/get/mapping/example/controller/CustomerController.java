package com.sb.get.mapping.example.controller;

import com.sb.get.mapping.example.response.APIResponse;
import com.sb.get.mapping.example.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/getAll")
    public ResponseEntity<APIResponse> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/getById/{customerId}")
    public ResponseEntity<APIResponse> getByCustomerId(@PathVariable long customerId) {
        return customerService.getByCustomerId(customerId);
    }
}
