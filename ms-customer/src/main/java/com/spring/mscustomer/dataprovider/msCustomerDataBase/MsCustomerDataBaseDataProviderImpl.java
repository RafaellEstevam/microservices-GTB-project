package com.spring.mscustomer.dataprovider.msCustomerDataBase;

import com.spring.mscustomer.dataprovider.msCustomerDataBase.entity.CustomerEntity;
import com.spring.mscustomer.dataprovider.msCustomerDataBase.repository.CustomerRepository;
import com.spring.mscustomer.domain.dataprovider.MsCustomerDataBaseDataProvider;
import com.spring.mscustomer.domain.model.Customer;
import com.spring.mscustomer.util.translator.CustomerEntityTranslator;
import com.spring.mscustomer.util.translator.CustomerTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MsCustomerDataBaseDataProviderImpl implements MsCustomerDataBaseDataProvider {

    private final CustomerRepository customerRepository;
    private final CustomerTranslator customerTranslator;
    private final CustomerEntityTranslator customerEntityTranslator;

    @Override
    public Optional<Customer> findById(Long id) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);
        return getOptionalCustomerOrEmpty(optionalCustomerEntity);
    }

    @Override
    public Optional<Customer> findByDocument(String document) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findByDocument(document);
        return getOptionalCustomerOrEmpty(optionalCustomerEntity);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findByEmail(email);
        return getOptionalCustomerOrEmpty(optionalCustomerEntity);
    }

    @Override
    public List<Customer> findAll() {
        return customerTranslator.execute(customerRepository.findAll());
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customerEntityTranslator.execute(customer));
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customerEntityTranslator.execute(customer));
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    private Optional<Customer> getOptionalCustomerOrEmpty(Optional<CustomerEntity> optionalCustomerEntity) {
        if (optionalCustomerEntity.isPresent()) {
            return Optional.of(customerTranslator.execute(optionalCustomerEntity.get()));
        }
        return Optional.empty();
    }
}
