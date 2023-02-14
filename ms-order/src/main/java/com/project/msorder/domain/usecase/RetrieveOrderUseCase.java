package com.project.msorder.domain.usecase;

import com.project.msorder.domain.dataprovider.mscustomer.MsCustomerDataProvider;
import com.project.msorder.domain.dataprovider.msorderdb.MsOrderDBDataProvider;
import com.project.msorder.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveOrderUseCase {

    private final MsCustomerDataProvider msCustomerDataProvider;
    private final MsOrderDBDataProvider msOrderDBDataProvider;


    public List<Order> retrieveByCustomer(Long customerId) {

        customerExistsOrThrowAnException(customerId);
        return msOrderDBDataProvider.retrieveOrderByCustomerId(customerId);
    }

    public Integer retrieveAmountByCustomer(Long customerId) {
        customerExistsOrThrowAnException(customerId);
        return msOrderDBDataProvider.retrieveAmountOfOrdersByCustomer(customerId);
    }

    private void customerExistsOrThrowAnException(Long customerId) {
        msCustomerDataProvider.retrieveById(customerId);
    }

}
