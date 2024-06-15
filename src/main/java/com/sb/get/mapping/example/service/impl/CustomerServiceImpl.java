package com.sb.get.mapping.example.service.impl;

import com.sb.get.mapping.example.model.CustomerModel;
import com.sb.get.mapping.example.response.APIResponse;
import com.sb.get.mapping.example.response.CustomerResponse;
import com.sb.get.mapping.example.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static com.sb.get.mapping.example.mapper.CustomerMapper.modelToResponseMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static List<CustomerModel> customers = new ArrayList<>();
    private static AtomicInteger c = new AtomicInteger(1);

    static {
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser1", 21, "7234567811", "testuser1@gmail.com", "Bangalore", LocalDate.now()));
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser2", 22, "7234567812", "testuser2@gmail.com", "Hyderabad", LocalDate.now()));
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser3", 23, "7234567813", "testuser3@gmail.com", "Chennai", LocalDate.now()));
        customers.add(new CustomerModel(c.getAndIncrement(), "testUser4", 24, "7234567814", "testuser4@gmail.com", "Pune", LocalDate.now()));
    }

    @Override
    public ResponseEntity<APIResponse> getAllCustomers() {

        List<CustomerResponse> customerLists = customers.stream()
                .map(customerModel -> modelToResponseMapper(customerModel))
                .toList();

        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(000)
                        .data(customerLists)
                        .build()
        );
    }

    @Override
    public ResponseEntity<APIResponse> getByCustomerId(long customerId) {
        Optional<CustomerResponse> customerResponseOptional = customers.stream()
                .filter(customerModel -> customerModel.getCustomerId() == customerId)
                .map(customerModel -> modelToResponseMapper(customerModel))
                .findFirst();

        if (customerResponseOptional.isPresent()) {
            return ResponseEntity.ok(
                    APIResponse.builder()
                            .errorCode(0)
                            .data(customerResponseOptional.get())
                            .build()
            );
        } else {
            return ResponseEntity.ok(
                    APIResponse.builder()
                            .errorCode(999)
                            .data("Customer is not available")
                            .build()
            );
        }
    }
}
