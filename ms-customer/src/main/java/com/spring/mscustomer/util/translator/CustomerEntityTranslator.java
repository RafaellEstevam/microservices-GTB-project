package com.spring.mscustomer.util.translator;

import com.spring.mscustomer.dataprovider.msCustomerDataBase.entity.CustomerEntity;
import com.spring.mscustomer.domain.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerEntityTranslator {

    public CustomerEntity execute(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId() == null ? null : customer.getId())
                .name(customer.getName())
                .document(customer.getDocument())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }
}
