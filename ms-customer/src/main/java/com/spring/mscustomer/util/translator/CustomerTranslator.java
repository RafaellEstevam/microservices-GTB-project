package com.spring.mscustomer.util.translator;

import com.spring.mscustomer.dataprovider.msCustomerDataBase.entity.CustomerEntity;
import com.spring.mscustomer.domain.model.Customer;
import com.spring.mscustomer.userinterface.dto.CustomerRequest;
import com.spring.mscustomer.userinterface.dto.CustomerUpdateRequest;
import com.spring.mscustomer.util.DocumentFormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerTranslator {

    private final DocumentFormatService documentFormatService;

    public Customer execute(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .document(documentFormatService.execute(customerRequest.getDocument()))
                .email(customerRequest.getEmail())
                .phone(customerRequest.getPhone())
                .address(customerRequest.getAddress())
                .build();
    }

    public Customer execute(CustomerUpdateRequest customerUpdateRequest){
        return Customer.builder()
                .name(customerUpdateRequest.getName())
                .document(documentFormatService.execute(customerUpdateRequest.getDocument()))
                .email(customerUpdateRequest.getEmail())
                .phone(customerUpdateRequest.getPhone())
                .address(customerUpdateRequest.getAddress())
                .build();
    }

    public Customer execute(CustomerEntity customerEntity){
        return Customer.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .document(customerEntity.getDocument())
                .email(customerEntity.getEmail())
                .phone(customerEntity.getPhone())
                .address(customerEntity.getAddress())
                .build();
    }

    public List<Customer> execute(List<CustomerEntity> customerEntities){
        return customerEntities.stream()
                .map(customerEntity -> execute(customerEntity))
                .collect(Collectors.toList());
    }
}
