package com.spring.mscustomer.dataprovider.msCustomerDataBase.repository;

import com.spring.mscustomer.dataprovider.msCustomerDataBase.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByDocument(String document);

    Optional<CustomerEntity> findByEmail(String email);

}
